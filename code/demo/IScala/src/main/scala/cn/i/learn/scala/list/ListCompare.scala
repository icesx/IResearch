package cn.i.learn.scala.list

object ListCompare {
  def main(args: Array[String]): Unit = {
    val l1 = (0 to 10).toList
    val l2 = (5 to 12).toList
    l1.map(x => (x, l2))
      .map(x => x._2.map(y => (x._1, y)))
      .flatMap(x => x)
      .foreach(println)
  }
}