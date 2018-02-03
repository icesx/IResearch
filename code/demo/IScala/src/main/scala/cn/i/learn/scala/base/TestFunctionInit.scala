package cn.i.learn.scala.base

object TestFunctionInit {
  def main(args: Array[String]): Unit = {
    (0 to 10).toList.map(x => {
      println("is not init")
      Init.show(x)
    })
  }
}
object Init {
  println("Int")
  def show(x: Int) {
    println(x)
  }
}