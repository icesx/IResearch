package cn.i.learn.scala.obj.sington

object LazySington {
  def say() = {
    println("yes")
  }
  def main(args: Array[String]): Unit = {
    LazySington.say()
  }
}