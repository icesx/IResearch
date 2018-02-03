package cn.i.xportal.spark.base

import cn.i.xportal.spark.ml.common.SparkUtils

object TupleDistinct {
  def main(args: Array[String]): Unit = {
    SparkUtils.sparkContent().parallelize(Seq(("1", "2"), ("1", "2"))).distinct.foreach(println)
  }
}