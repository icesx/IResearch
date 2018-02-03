package cn.i.learn.scala.base.apply

class ApplyClass {
  def apply() = {
    "this is apply class"
  }
  def say() = {
    println("hello")
  }
}
object TestAC {
  def main(args: Array[String]): Unit = {
    new ApplyClass().say()
    println(new ApplyClass())
  }
}