package cn.i.xportal.spark.base

import cn.i.xportal.spark.ml.common.SparkUtils

object Union {
  def main(args: Array[String]): Unit = {
    val sc=SparkUtils.sparkContent()
    val rdd = sc.parallelize(Seq(1, 2, 3, 4, 5, 3, 2, 0))
    val rdd1 = sc.parallelize(Seq(10, 11, 12, 14, 15, 19))
    rdd.union(rdd1).foreach(println)
  }
}