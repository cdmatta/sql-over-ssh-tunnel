package com.charandeepmatta.dbtunnel

class SampleDataFetcher extends DatabaseWrappedWithSshTunnel {
  def countRowsInTable: Int = {
    performDbOperation(_.queryForInt("select count(*) from customer"))
  }
}

object SampleDataFetcher {
  def main(args: Array[String]): Unit = {
    println(new SampleDataFetcher().countRowsInTable)
  }
}
