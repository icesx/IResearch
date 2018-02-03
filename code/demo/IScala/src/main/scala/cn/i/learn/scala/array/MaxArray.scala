package cn.i.learn.scala.array

object MaxArray {
  def main(args: Array[String]): Unit = {
    var arrayMax = Integer.MAX_VALUE / 2
    println(new Array[Byte](arrayMax).length)
    arrayMax = 40000 * 40000
    println(arrayMax)
    println(new Array[Byte](arrayMax).length)
  }
}