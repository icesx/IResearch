package cn.i.learn.scala.obj

object ObjectTest {
  def fun(f:(String)=>Unit)={
    f("x")
  }
  def main(args: Array[String]): Unit = {
    fun(ObjectInit.show(_))
  }
}
object ObjectInit{
  println("init")
  def show(x:String)={
    println(x)
  }
}