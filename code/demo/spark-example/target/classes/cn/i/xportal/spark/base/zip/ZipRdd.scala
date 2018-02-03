package cn.i.xportal.spark.base.zip

import cn.i.xportal.spark.ml.common.SparkUtils
import org.apache.log4j.Logger
import org.apache.log4j.Level

object ZipRdd {
  Logger.getLogger("org").setLevel(Level.OFF)
  def main(args: Array[String]): Unit = {
    val sc = SparkUtils.sparkContent()
    val rdd1 = sc.parallelize(Seq("A", "B", "C"))
    val rdd2 = sc.parallelize(Seq(1, 2, 3))
    rdd1.zip(rdd2).foreach(println)
  }
}