package cn.i.xportal.spark.ml.corr;
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.stat.Statistics
import org.apache.spark.{ SparkConf, SparkContext }
import cn.i.xportal.spark.ml.common.SparkUtils

object Spearman {
  def main(args: Array[String]) {
    val sc = SparkUtils.sparkContent()
    val rddX = sc.parallelize(Seq(1, 2, 3, 4, 5).map(_.toDouble))
    val rddY = sc.parallelize(Seq(2, 4, 6, 8, 10).map(_.toDouble))
    val correlation: Double = Statistics.corr(rddX, rddY, "spearman") //计算不同数据之间的相关系数
    println(correlation)
  }
}
