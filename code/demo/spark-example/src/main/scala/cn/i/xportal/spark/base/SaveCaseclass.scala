package cn.i.xportal.spark.base

import cn.i.xportal.spark.ml.common.SparkUtils

object SaveCaseclass {
  case class Person(name: String, age: Int){
    override def productPrefix = ""
  }
  def main(args: Array[String]): Unit = {
    val sc = SparkUtils.sparkContent()
    val rdd1 = sc.parallelize(Seq(("A", 2), ("B", 3), ("C", 3), ("C", 1), ("d", 0)))
    .map(x=>Person(x._1,x._2))
    rdd1.saveAsTextFile("classcase_file")
    val rdd2 = sc.textFile("classcase_file")
  }
}