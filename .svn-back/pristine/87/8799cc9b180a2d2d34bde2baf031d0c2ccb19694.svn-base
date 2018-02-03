package cn.i.learn.scala.array

object ArraySample {
  def sampleArray() = {
    val greetStrings = new Array[String](3)
    greetStrings(0) = "Hello"
    greetStrings(1) = ", "
    greetStrings(2) = "world!\n"
    greetStrings.+:("end")
    greetStrings.foreach { println }
  }
  def main(args: Array[String]): Unit = {
    sampleArray()
    val a = new Array[Int](3)
    a(0) = 1
    a(1) = 1
    a
      .map(_.toString)
      .foreach(println)
  }
}