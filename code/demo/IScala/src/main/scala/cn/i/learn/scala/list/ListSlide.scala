package cn.i.learn.scala.list

object ListSlide {
  def main(args: Array[String]): Unit = {
    val xs = List(1, 2, 3, 4, 3, 5)
    for (List(left, right) <- xs.sliding(2) if (left < right)) println(left + " < " + right)
    println("---")
    for (List(left, right) <- xs.sliding(2)) println(left + " < " + right)
    println("---")
    for ((left, right) <- (xs zip xs.tail) if (left < right)) println(left + " < " + right)
    println("---")
    xs.zip(xs.tail).foreach(println)
    println("---")
    xs.zip(xs).foreach(println)
  }
}