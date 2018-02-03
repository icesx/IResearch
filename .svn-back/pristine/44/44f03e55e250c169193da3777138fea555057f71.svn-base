package cn.i.learn.scala.function

object CurryingFunction {
  def perpal(i: Int)(j: Int)(k: Int): Int = {
    i + j + k
  }
  def main(args: Array[String]): Unit = {
    print(perpal(1)(2)(3))
    val perpel1 = perpal(1)_
    print(perpel1(2))
  }
}