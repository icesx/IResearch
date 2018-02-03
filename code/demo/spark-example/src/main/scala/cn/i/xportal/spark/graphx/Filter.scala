package cn.i.xportal.spark.graphx

import cn.i.xportal.spark.ml.common.SparkUtils

object Filter {
  def main(args: Array[String]): Unit = {
    val sc = SparkUtils.sparkContent()
    val rdd = sc.parallelize(Seq("2", "3", "$"))
    rdd.filter(!_.equals("2")).foreach(println)
    println("---left equal value---remove not equal value---")
    rdd.filter(_.equals("2")).foreach(println)
  }
}