package cn.i.learn.scala.list

object zip {
  def main(args: Array[String]): Unit = {
    val numbers = Seq(0, 1, 2, 3, 4)
    val index=Seq(0,11,22,33,44,45)
    println(numbers zip index)
    println(numbers.zip(index))
  }
}