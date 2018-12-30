package cn.i.learn.scala.function

object MultiReture {
  def getStockInfo = {
    ("NFLX", 100.00, 101.00)
  }
  def main(args: Array[String]): Unit = {
    val (symbol, currentPrice, bidPrice) = getStockInfo
    println(symbol,currentPrice,bidPrice)
    println(-5%11)
  }
}