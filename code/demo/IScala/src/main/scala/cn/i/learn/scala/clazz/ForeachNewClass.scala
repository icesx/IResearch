package cn.i.learn.scala.clazz

object ForeachNewClass {

  def main(args: Array[String]): Unit = {
    (1 to 10).toList.foreach(x => new Run().me())
  }

}
class Run() {
  def me() = {
    println(this)
  }
}