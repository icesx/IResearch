package cn.i.xportal.spark.base.join

import cn.i.xportal.spark.ml.common.SparkUtils
import org.apache.log4j.Logger
import org.apache.log4j.Level
import org.apache.spark.rdd.RDD.rddToPairRDDFunctions

object Join2 {
  Logger.getLogger("org").setLevel(Level.OFF)
  def main(args: Array[String]): Unit = {
    val sc = SparkUtils.sparkContent()
    val rdd1 = sc.parallelize(Seq(("A", "2"), ("B", "3"), ("C", "3"),("C","2"),("D","1"),("F","2")))
    val rdd2 = sc.parallelize(Seq(("A", "A"), ("B", "B"), ("C", "C")))
    rdd1
      .join(rdd2)
      .map(x=>List((x._1,x._2._1),(x._1,x._2._2)))
      .flatMap(x=>x)
      .filter(x=>x._1!=x._2)
      .distinct()
      .foreach(println)
  }
}