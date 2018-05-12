package cn.i.learn.scala.base

object FlatMapTrup {
  def main(args: Array[String]): Unit = {
    val list = List(List(1, 2), List(3, 4))
    list.foreach(println)
    println("---")
    val list2 = list.map(_.map(x => (x, x)))
    list2.foreach(println)
    println("---")
    list2.flatMap(x => x).foreach(println)
    println("---")
    list2.flatMap(x => x.map(_._1 * 2)).foreach(println)
    println("---")
    list.flatMap(x => x).foreach(println)
  }
}