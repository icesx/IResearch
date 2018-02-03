package cn.i.learn.scala.function

class Functon4 {
  def fun(callback: () => Int) = {
    println(callback())
  }
  def fun2(callback: (Int) => Int): Int = {
    callback(2)
  }
}
object run {
  def main(args: Array[String]): Unit = {
    val fun: Functon4 = new Functon4
    fun.fun(() => 5)
    println(fun.fun2 { x => x * 6 })
    println(fun.fun2(x => x * 7))
    println(fun.fun2 { _ * 8 })
  }
}