package cn.i.xportal.spark.base.join

import cn.i.xportal.spark.ml.common.SparkUtils
import org.apache.log4j.Logger
import org.apache.log4j.Level
import org.apache.spark.rdd.RDD.rddToPairRDDFunctions

object Join3 {
  Logger.getLogger("org").setLevel(Level.OFF)
  def main(args: Array[String]): Unit = {
    val sc = SparkUtils.sparkContent()
    val rdd1 = sc.parallelize(Seq((1, 2, 1), (1, 2, 3), (1, 3, 4), (2, 4, 1), (4, 5, 8), (1, 9, 5)))
    val rdd2 = sc.parallelize(Seq((1, "A"), (2, "B"), (3, "C")))
    rdd1.map(x => (x._1, (x._2, x._3)))
      .join(rdd2)
      .map(x => (x._2._2, x._2._1))
      .map(x => (x._2._2, (x._2._1, x._1)))
      .join(rdd2)
      .map(x => (x._2._2, x._2._1))
      .map(x => (x._2._1, x._1, x._2._2))
      .foreach(println)
  }
}