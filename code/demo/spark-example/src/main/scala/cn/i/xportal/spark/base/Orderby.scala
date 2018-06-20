package cn.i.xportal.spark.base

import cn.i.xportal.spark.ml.common.SparkUtils
import scala.util.Random
import org.apache.spark.rdd.RDD

object Orderby {
  def top(rdd: RDD[(Int, Int)]) = {
    rdd
      .top(10)
      .foreach(println)
  }
  def take(rdd: RDD[(Int, Int)]) = {
    rdd
      .sortBy(_._2)
      .take(10)
      .foreach(println)
  }
  def ordering(rdd: RDD[(Int, Int)]) = {
    rdd
      .top(10)(Ordering[Int].reverse.on(_._2))
      .foreach(println)
  }
  def main(args: Array[String]): Unit = {

    val rdd = SparkUtils
      .sparkContent()
      .parallelize((0 to 100).map(x => (x, Random.nextInt(10))))
    top(rdd)
    println("-------------------")
    take(rdd)
    println("-------------------")
    ordering(rdd)
  }
}