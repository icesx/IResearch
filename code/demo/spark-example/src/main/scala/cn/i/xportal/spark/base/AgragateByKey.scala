package cn.i.xportal.spark.base

import cn.i.xportal.spark.ml.common.SparkUtils
import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.rdd.RDD
import scala.reflect.ClassTag
import scala.collection.mutable.ArrayBuffer

object AgragateByKey {
  Logger.getLogger("org").setLevel(Level.OFF)
  def main(args: Array[String]): Unit = {
    val sc = SparkUtils.sparkContent()
    val rdd = sc.parallelize(List((1, 3), (1, 2), (1, 4), (2, 3)))
      .map(x => (x._1.toString(), x._2.toString()))
    var time = System.currentTimeMillis()
    for (i <- 0 to 10000) {
      aggregate(rdd)
    }
    println("use1 " + (System.currentTimeMillis() - time))
    time = System.currentTimeMillis()
    for (i <- 0 to 10000) {
      aggregate2(rdd)
    }
    println("use1 " + (System.currentTimeMillis() - time))

  }
  def aggregate[T: ClassTag](rdd: RDD[(String, T)]) = {
    rdd.aggregateByKey(List[T]())((l, b: T) => l.+:(b), (a, b) => a ++ b)
    .collect()

  }
  def aggregate2[T: ClassTag](rdd: RDD[(String, T)]) = {
    rdd.aggregateByKey(ArrayBuffer[T]())((l, b: T) => l.+:(b), (a, b) => a ++ b)
    .collect()
  }
}