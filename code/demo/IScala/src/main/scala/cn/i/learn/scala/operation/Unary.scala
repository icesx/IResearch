package cn.i.learn.scala.operation

class Foo(val v: Int) {
  def unary_+ = 1 * v
  def unary_- = -1 * v
  def unary_! = { if (v != 0) false else true }
}
object xx {
  def main(args: Array[String]): Unit = {
    val foo = new Foo(5)
    +foo / 5
    -foo / -5
    !foo
  }
}