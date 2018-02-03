package cn.i.learn.scala.obj.sington

class InstanceSington {
  private val name = "instance"
  def sayMe() = {
    println(name)
  }
}
object InstanceSington {
  private val is = new InstanceSington
  def instance(): InstanceSington = {
    is
  }
  def main(args: Array[String]): Unit = {
    for (i <- 1 to 5) {
      println(InstanceSington.instance())
    }
  }
}