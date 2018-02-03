package cn.i.xportal.spark.base.join

import cn.i.xportal.spark.ml.common.SparkUtils
import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.rdd.RDD.rddToPairRDDFunctions

object Join {
  Logger.getLogger("org").setLevel(Level.OFF)
  def main(args: Array[String]): Unit = {
    val sc = SparkUtils.sparkContent()
    val rdd1 = sc.parallelize(Seq(("A", "2"), ("B", "3"), ("C", "3"),("C","2")))
    val rdd2 = sc.parallelize(Seq(("A", "4"), ("A", "5"), ("B", "4")))
    rdd1
      .join(rdd2)
      .distinct()
      .foreach(println)
  }
}