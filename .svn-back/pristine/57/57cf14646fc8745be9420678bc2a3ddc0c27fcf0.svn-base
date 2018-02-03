package cn.i.learn.scala.base

import scala.util.Random

object SortTest {
  def main(args: Array[String]): Unit = {
    val list = List(("a", 1), ("b", 2), ("c", 3), ("d", 4), ("f", 5),("g",6))
    list.foreach(print)
    println()
    list.sortBy(_ =>
      Random.nextBoolean()).foreach(print)
  }
}