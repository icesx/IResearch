package cn.i.learn.scala.list

/**
 * filter leave
 * @author i
 *
 */
object ListFilter {
  def main(args: Array[String]): Unit = {
    val file = List("warn 2013 msg", "warn 2012 msg",
      "error 2013 msg", "warn 2013 msg")
    println("cat file | grep 'warn' | grep '2013' | wc : "
      + file.filter(_.contains("warn")))
    //as grep
    List("1", "2", "3").filter(_.equals("1")).foreach(println)
  }
}