package com.charandeepmatta.dbtunnel

sealed abstract class DatabaseInstance(val host: String, val port: Int, val userName: String, val sid: String) {
  def getAllAttributes(password: String) = {
    (host, port, userName, password, sid)
  }

  val propertyName = this.getClass.getSimpleName

  val driverClass = "com.mysql.jdbc.Driver"

  def jdbcUrl(dbPortOnLocalHost: Int) = "jdbc:mysql://localhost:" + dbPortOnLocalHost + "/" + sid
}

case object DatabaseInstanceOne extends DatabaseInstance("dbHost1", 3306, "myuserid", "test")

case object DatabaseInstanceTwo extends DatabaseInstance("dbHost2", 3307, "myuserid", "test")
