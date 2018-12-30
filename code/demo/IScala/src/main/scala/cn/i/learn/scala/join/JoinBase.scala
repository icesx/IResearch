package cn.i.learn.scala.join

object JoinBase {
  def main(args: Array[String]): Unit = {
    val l1=(1 to 10).toList.union((1 to 10).toList).map(x=>(x,x))
    val l2=l1
  }
}