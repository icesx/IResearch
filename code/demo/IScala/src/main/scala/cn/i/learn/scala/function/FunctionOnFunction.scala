package cn.i.learn.scala.function

object FunctionOnFunction {
  def fun1(f: () => String): Unit = {
    println(f())
  }
  def main(args: Array[String]): Unit = {
    FunctionOnFunction.fun1(() => "x")
    FunctionOnFunction.fun1(fun2)
    fun3((x) => x + "1")
    fun3(fun4(_))
  }
  def fun2(): String = {
    "y"
  }
  def fun3(f: (String) => String): Unit = {
    println(f("x"))
  }
  def fun4(s: String): String = {
    s + "2"
  }
}