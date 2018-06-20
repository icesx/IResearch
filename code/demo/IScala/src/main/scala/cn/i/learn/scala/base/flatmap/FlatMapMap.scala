package cn.i.learn.scala.base.flatmap

object FlatMapMap {
  def main(args: Array[String]): Unit = {
    List(("1", List("11", "13")), ("2", List("21", "22"))).map(x => x._2.map(y => (x._1, y))).flatMap(x => x).foreach(println)
  }
}