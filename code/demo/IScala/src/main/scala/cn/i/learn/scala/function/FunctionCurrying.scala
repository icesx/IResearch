package cn.i.learn.scala.function

object FunctionCurrying {
  def duble(x: Int)(y: Int): Int = {
    x + y
  }
  def duble2(x: Int, y: Int): Int = {
    x + y
  }
  def duble3(x: Int)(y: (Int) => Int): Int = {
    y(x)
  }
  def duble4(x: Int, y: (Int) => Int): Int = {
    y(x)
  }
  def duble5(x: Int) = (y: Int) => x + y
  def main(args: Array[String]): Unit = {
    println(duble(1)(2))
    println(duble2(1, 2))
    println(duble3(1)(i => (i + 10)))
    println(duble3(1)_)
    println(duble4(1, _ + 10))
    println(duble5(1)(2))
  }
}