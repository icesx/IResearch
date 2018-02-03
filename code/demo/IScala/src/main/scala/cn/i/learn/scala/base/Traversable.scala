package cn.i.learn.scala.base

object Traversable {
    def fun(s: String): Traversable[String] = {
        s.split(" ")
    }
    def fun2(callback: (String) => Traversable[String]) = {
        callback("a b")
    }
    def main(args: Array[String]): Unit = {
        fun2(fun).foreach(println)
    }
}