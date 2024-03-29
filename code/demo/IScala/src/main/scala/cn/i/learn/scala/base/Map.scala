package cn.i.learn.scala.base

object MapMe {
  def map(x: String): Map[String, Int] = {
    Map(x -> 1, x -> 2)
  }
  def map2(m: Map[String, Int]) = {
    m.foreach(println)
  }
  def main(args: Array[String]): Unit = {
    map("a").foreach(x => println(x))
    println(map("b").map(_._2))
    map2(map("b"))
    println(mapAppend())
  }
  def mapAppend() = {
    var map = Map("a" -> 1)
    map += ("b" -> 2)
    map += ("c" -> 3)
    map + ("d" -> 4)
  }
}