package cn.i.learn.scala.list

object ListSort {
  def main(args: Array[String]): Unit = {
    println(List(1, 2, 3).map(x => (x, x)).sortBy(_._1).map(_._1).mkString(","))
    println(List(1, 2, 3).map(x => (x, x)).sortBy(Integer.MAX_VALUE - _._1).map(_._1).mkString(","))
    println(List(1, 2, 3).map(x => (x, x)).sortBy(-_._1).map(_._1).mkString(","))
    println(List(1, 2, 3).map(x => (x, x)).sortBy(-_._1).reverse.map(_._1).mkString(","))
  }
}