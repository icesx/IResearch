package cn.i.xportal.spark.ml.comput

import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.stat.Statistics
import cn.i.xportal.spark.ml.common.SparkUtils

object SingleCorrelation {
	def main(args: Array[String]): Unit = {
		val rdd=SparkUtils.sparkContent().textFile("data/mydata/corr/x").map(_.split(" ").map(_.toDouble)).map(x => Vectors.dense(x))
		println("斯皮尔曼："+Statistics.corr(rdd, "spearman"))
	}
}