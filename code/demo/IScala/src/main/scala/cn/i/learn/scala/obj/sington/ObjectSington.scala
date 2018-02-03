package cn.i.learn.scala.obj.sington

import scala.collection.mutable.ListBuffer

class ObjectSington {
  def hello(x: String): Unit = {
    println("hello " + x)
  }
}
object ObjectSington {
  val os = new ObjectSington()
  def world(): Unit = {
    os.hello("world")
  }
  def main(args: Array[String]): Unit = {
    ObjectSington.world()
  }
}