package cn.i.xportal.spark.base.group

import cn.i.xportal.spark.ml.common.SparkUtils
import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.rdd.RDD.rddToPairRDDFunctions

object Group {
  Logger.getLogger("org").setLevel(Level.OFF)
  def main(args: Array[String]): Unit = {
    val sc = SparkUtils.sparkContent()
    val rdd1 = sc.parallelize(Seq(("A", "A11"), ("B", "3"), ("C", "3"),("C","2"),("A","A12")))
    val rdd2 = sc.parallelize(Seq(("A", "A21"), ("A", "A22"), ("B", "4")))
    rdd1
      .union(rdd2)
      .groupByKey()
      .distinct()
      .foreach(println)
  }
}