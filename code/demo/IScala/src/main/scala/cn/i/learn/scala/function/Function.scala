package cn.i.learn.scala.function

object Function {
  def square(a: Int) = a * a

  def squareWithBlock(a: Int) = {
    a * a
  }

  val squareVal = (a: Int) => a * a

  def addOne(f: Int => Int, arg: Int) = f(arg) + 1
  def voidF = () => println("ok")

  def main(args: Array[String]): Unit = {
    println("square(2):" + square(2))
    println("squareWithBlock(2):" + squareWithBlock(2))
    println("squareVal(2):" + squareVal(2))
    println("addOne(squareVal,2):" + addOne(squareVal, 2))
    voidF()
  }

}