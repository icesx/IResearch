package cn.i.learn.scala.implici

import MyConversions._
object Main {
    def wrap(x: String) = {
        println(x)
    }
    def main(args: Array[String]): Unit = {
        wrap(1)
    }
}