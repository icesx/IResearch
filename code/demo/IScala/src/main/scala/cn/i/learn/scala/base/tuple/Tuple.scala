package cn.i.learn.scala.base.tuple

import java.util.Date

object Tuple {

    def simpleTuples() = {
        val tedsStartingDateWithScala = Date.parse("3/7/2006")
        val tuple = ("Ted", "Scala", tedsStartingDateWithScala)
        println(tuple._1)
        println(tuple._2)
        println(tuple._3)
    }
    def main(args: Array[String]): Unit = {
        simpleTuples()
    }
}