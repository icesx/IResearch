package cn.i.learn.scala.foldleft

object Main {
  def main(args: Array[String]): Unit = {
    val list = (0 to 10).toList.map(_.toString)
    list.foreach(println(_))
    println("___")
    println(list.foldLeft("A")((A, result) => {
      println("value:" + result + ",A:" + A)
      A + result
    }))
    println("___")
    println(list.foldRight("A")((A, result) => {
      println("value:" + result + ",A:" + A)
      A + result
    }))
  }
}