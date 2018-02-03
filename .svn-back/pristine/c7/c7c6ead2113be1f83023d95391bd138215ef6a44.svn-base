package cn.i.learn.scala.list

object ListSplit {
  def main(args: Array[String]): Unit = {
    (0 to 10).toList.sliding(3).foreach(x=>{
      println(x.mkString(","))
    })
    println("---")
    (0 to 10).toList.sliding(3, 3).foreach(x=>println(x.mkString(",")))
  }
}