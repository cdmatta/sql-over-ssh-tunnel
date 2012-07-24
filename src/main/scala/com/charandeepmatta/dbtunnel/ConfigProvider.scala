package com.charandeepmatta.dbtunnel

object ConfigProvider {
  def getDatabaseConfig() = {
    System.getProperty("dbInstanceName") + "$" match {
      case DatabaseInstanceOne.propertyName => DatabaseInstanceOne
      case DatabaseInstanceTwo.propertyName => DatabaseInstanceTwo
      case _ => DatabaseInstanceOne
    }
  }

  def getSshPassword = getSystemConfigElseFail("sshHostPassword")

  def getDbPassword = getSystemConfigElseFail("dbPassword")

  def getSystemConfigElseFail(propertyName: String) = {
    Option(System.getProperty(propertyName)) match {
      case Some(value) => value
      case None => throw new RuntimeException("Property with name " + propertyName + " is undefined.")
    }
  }
}
