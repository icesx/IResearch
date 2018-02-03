package cn.i.xportal.spark.ml.corr;
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.stat.Statistics
import org.apache.spark.{ SparkConf, SparkContext }
import cn.i.xportal.spark.ml.common.SparkUtils

object SingleSpearman {
  def main(args: Array[String]) {
    val sc = SparkUtils.sparkContent()
    val rddX = sc.parallelize(Seq(1, 2, 3, 4, 5).map(_.toDouble).map(x => Vectors.dense(x)))
    val correlation = Statistics.corr(rddX, "spearman")
    println(correlation)
  }
}
