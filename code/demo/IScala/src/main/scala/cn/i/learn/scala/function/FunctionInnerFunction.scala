package cn.i.learn.scala.function

object FunctionInnerFunction {
  def fun1(){
    def fun2(){
      println("fun2")
    }
    fun2
  }
  def main(args: Array[String]): Unit = {
    fun1
  }
}