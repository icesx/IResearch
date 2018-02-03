package cn.i.xportal.spark.base

import cn.i.xportal.spark.ml.common.SparkUtils
import scala.util.Random

object Orderby {
  def main(args: Array[String]): Unit = {
    SparkUtils
      .sparkContent()
      .parallelize(Seq("1", "2", "3", "4"))
      .sortBy(_ => Random.nextBoolean())
      .foreach(println)
  }
}