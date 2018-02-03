package cn.i.learn.scala.implici
import scala.collection.JavaConversions._
object MyConversions {
    implicit def intToString(x: Int): String = x.toString() + "I"
    implicit def foreach(x: Int) = println(x)
}