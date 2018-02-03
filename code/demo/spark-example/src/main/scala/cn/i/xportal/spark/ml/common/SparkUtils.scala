package cn.i.xportal.spark.ml.common

import org.apache.spark.SparkContext
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

object SparkUtils {
  def sparkContent(): SparkContext = {
    val conf = new SparkConf().setMaster("local").setAppName("")
    new SparkContext(conf)
  }
  def sparkSession(): SparkSession = {
    SparkSession
      .builder().master("local")
      .appName("Spark SQL basic example")
      .config("spark.some.config.option", "some-value")
      .getOrCreate()
  }
}