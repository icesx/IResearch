package cn.i.learn.scala.base

object Zipped {
  def main(args: Array[String]): Unit = {
    val a1=(0 to 10).toList.toArray
    val a2=(0 to 13).toList.map(_+"X").toArray
    (a1,a2).zipped.foreach((x,y)=>println(x,y))
  }
}