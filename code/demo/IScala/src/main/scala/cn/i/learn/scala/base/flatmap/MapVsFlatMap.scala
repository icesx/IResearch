package cn.i.learn.scala.base.flatmap

object MapVsFlatMap {
  val list = (1 to 10).toList
  def map = {
    list.map(x => 2 * x)
  }
  def flatMap = {
    list.flatMap(x => Map(x -> x))
  }
  val nestedNumbers = List(List(1, 2), List(3, 4))
  def flatMap2 = {
    nestedNumbers.flatMap(x => x.map(_ * 2))
  }
  def flatMap3 = {
    nestedNumbers.flatMap(x => x)
  }
  def flatMap4={
    List((1,2),(3,4)).flatMap(x=>List(x._1,x._2))
  }
  def map2 = {
    nestedNumbers.map(x => x.map(_ * 2))
  }
  def main(args: Array[String]): Unit = {
    println("map:" + map)
    println("flatMap" + flatMap)
    println("flatmap2:" + flatMap2)
    println("flatmap3:" + flatMap3)
    println("flatmap4:" + flatMap4)
    println("map2:" + map2)
  }
}