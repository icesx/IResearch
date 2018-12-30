package cn.i.xportal.spark.base

import cn.i.xportal.spark.ml.common.SparkUtils
import org.apache.log4j.Level
import org.apache.log4j.Logger

object SaveText {
  Logger.getLogger("org").setLevel(Level.OFF)
  def main(args: Array[String]): Unit = {
    val sc = SparkUtils.sparkContent()
    val rdd1 = sc.parallelize(Seq(("A", 2), ("B", 3), ("C", 3), ("C", 1), ("d", 0)))
    rdd1.saveAsTextFile("text_file")
    val rdd2=sc.textFile("text_file")
    rdd2.foreach(println)
  }
}