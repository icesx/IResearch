package cn.i.learn.scala.function

object FunctionOnFunction {
  def fun1(f: () => String): Unit = {
    println(f())
  }
  def main(args: Array[String]): Unit = {
    FunctionOnFunction.fun1(() => "x")
  }
}