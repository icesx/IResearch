package cn.i.xportal.spark.base

import cn.i.xportal.spark.ml.common.SparkUtils

object Broadcast {
  def main(args: Array[String]): Unit = {
    val sc = SparkUtils.sparkContent()
    val x = 1
    sc.parallelize(Array(1, 2, 3, 4), 2).map(f => {
      f + x
    }).foreach(println)
  }
}