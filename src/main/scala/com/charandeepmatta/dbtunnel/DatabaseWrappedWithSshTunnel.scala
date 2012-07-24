package com.charandeepmatta.dbtunnel

import com.jcraft.jsch.JSch
import java.util.{Properties => JProperties}
import java.sql.DriverManager
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.datasource.SingleConnectionDataSource

trait DatabaseWrappedWithSshTunnel extends SshConnectionConfig {
  val dbInstanceClass = ConfigProvider.getDatabaseConfig
  val sshPassword = ConfigProvider.getSshPassword

  val driverClass = dbInstanceClass.driverClass
  val jdbcUrl = dbInstanceClass.jdbcUrl(dbPortOnLocalHost)
  val dbHost = dbInstanceClass.host
  val dbPort = dbInstanceClass.port
  val dbUserName = dbInstanceClass.userName
  val dbPassword = ConfigProvider.getDbPassword


  def performDbOperation[T](operation: (JdbcTemplate) => T):T = {
    val session = setup
    val (connection, template) = dbSetup
    val result = operation(template)
    connection.close
    session.disconnect
    result
  }

  private def setup() = {
    val jsch = new JSch
    val session = jsch.getSession(sshUserName, sshHost, sshPort)
    val config = new JProperties
    config.put("StrictHostKeyChecking", "no")
    session.setConfig(config)
    session.setPassword(sshPassword)
    session.setPortForwardingL(dbPortOnLocalHost, dbHost, dbPort)
    session.connect
    session
  }

  private def dbSetup() = {
    Class.forName(driverClass)
    val connection = DriverManager.getConnection(jdbcUrl, dbUserName, dbPassword)
    val template = new JdbcTemplate(new SingleConnectionDataSource(connection, false))
    (connection, template)
  }
}

trait SshConnectionConfig {
  val sshHost = "mySshHost"
  val sshUserName = "sshUserId"
  val sshPort = 22

  val dbPortOnLocalHost = 50000
}