package cn.i.learn.scala.filter

object Filter {
  def main(args: Array[String]): Unit = {
    List("1", "2", "3").filter(_.equals("1")).foreach(println)
  }
}