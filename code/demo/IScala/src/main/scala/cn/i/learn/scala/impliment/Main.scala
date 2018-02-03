package cn.i.learn.scala.impliment

object Main {
  def exec(i: IInterface): Unit = {
    i.doing(i.who())
  }
  def main(args: Array[String]): Unit = {
    exec(new IInterface() {
      def doing(who: String): Unit = {
        println(who)
      }
      def who(): String = {
        "you"
      }
    })
  }
}