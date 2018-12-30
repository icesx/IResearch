package cn.i.learn.scala.array

object ArrayPlus {
  def main(args: Array[String]): Unit = {
    val array = Array("1", "2", "3")
    val array2 = Array("4", "5")
    println(array.++:(array2).mkString(","))
    println(array.++(array2).mkString(","))
    println(array.++(1 to 5).toList.mkString(","))
  }
}