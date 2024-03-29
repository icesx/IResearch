package cn.i.learn.scala.loops

object For {
  def main(args: Array[String]): Unit = {
    val file = List("warn 2013 msg", "warn 2012 msg",
      "error 2013 msg", "warn 2013 msg")
    def wordcount(str: String): Int = str.split(" ").count("msg" == _)
    val counts =
      for (line <- file)
        yield wordcount(line)
    val num = counts.reduceLeft(_ + _)
    println("wordcount:" + num)
  }
}