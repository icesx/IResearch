package cn.i.learn.scala.base.flatmap

object ListFmap {
    def main(args: Array[String]): Unit = {
        val list = List(List(1, 1, 2), List(0, 3, 2, 1))
        list.flatMap(f => f).foreach(println)
        println("-------")
    }
}