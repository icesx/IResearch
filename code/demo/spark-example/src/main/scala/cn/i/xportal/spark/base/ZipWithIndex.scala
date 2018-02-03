package cn.i.xportal.spark.base

import cn.i.xportal.spark.ml.common.SparkUtils
import org.apache.log4j.Level
import org.apache.log4j.Logger

object ZipWithIndex {
  Logger.getLogger("org").setLevel(Level.OFF)
  def main(args: Array[String]): Unit = {
    val sc = SparkUtils.sparkContent()
    val rdd1 = sc.parallelize(Seq("z","A", "B", "C", "C", "d"))
    rdd1.zipWithIndex().foreach(println)
  }
}