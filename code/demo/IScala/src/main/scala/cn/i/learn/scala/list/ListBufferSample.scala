package cn.i.learn.scala.list

import scala.collection.mutable.ListBuffer

object ListBufferSample {
  def main(args: Array[String]): Unit = {
    val list: ListBuffer[String] = new ListBuffer
    for (i <- 0 to 5)
      list.+=(i.toString())
    println(list.mkString(","))
    list.clear()
    for (i <- 0 to 10)
      list.+=:(i.toString())
    println(list.mkString(","))
    list.clear()
    for (i <- 0 to 10)
      list.+=(i.toString())
    println(list.mkString(","))
  }
}