package cn.i.learn.scala.java

import java.util.ArrayList

object ScalaJava {
  def scala2Java(): Unit = {
    val j = new Java
    val list = (0 to 10).map(_ + "A").toList
    import scala.collection.JavaConversions._
    val listBack = j.list(list)
    listBack.foreach(println)
  }
  def java2Scala() = {
    val javaList: java.util.List[String] = new ArrayList
    import scala.collection.JavaConverters._
    list(javaList.asScala.toList)
  }
  def list(list: List[String]): List[String] = {
    list
  }
}