package cn.i.learn.scala.list

import scala.collection.mutable.ListBuffer

object ListAppend {
  def main(args: Array[String]): Unit = {
    var list: List[Int] = List()
    list.++(List(1, 2)).foreach { println }
    println("---")
    list.+:(3)
    list.foreach(println)
    println("---")
    val list2: ListBuffer[String] = new ListBuffer
    list2.+=("x").+=("y").+=:("z")
    list2.foreach(println)
  }
}