package cn.i.learn.scala.implici
import scala.collection.JavaConversions._
object MyConversions {
  implicit def intToString(x: Int): String = x.toString() + "I"
  implicit def foreach(x: Int) = println(x)
  implicit def stringToString(s: String) = new Implicis.StringImprovements(s)
}
object Implicis {
  implicit class StringImprovements(s: String) {
    def increment = s.map(c => (c + 1).toChar)
  }
}
