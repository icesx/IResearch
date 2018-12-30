package cn.i.xportal.spark.base

import cn.i.xportal.spark.ml.common.SparkUtils
import org.apache.log4j.Level
import org.apache.log4j.Logger

object TupleDistinct {
  Logger.getLogger("org").setLevel(Level.OFF)
  def main(args: Array[String]): Unit = {
    SparkUtils.sparkContent().parallelize(Seq(("1", "2"), ("1", "2"))).distinct.foreach(println)
  }
}