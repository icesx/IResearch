package cn.i.learn.scala.implici

import MyConversions._
import MyConversions.intToString
object Main {
    def wrap(x: String) = {
        println(x)
    }
    def main(args: Array[String]): Unit = {
    		println("x".increment)
        wrap(1)
    }
}