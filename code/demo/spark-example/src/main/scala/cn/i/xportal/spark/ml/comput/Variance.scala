package cn.i.xportal.spark.ml.comput

import org.apache.spark.SparkConf
import org.apache.spark.ml.linalg.Vector
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.stat.Statistics
import cn.i.xportal.spark.ml.common.SparkUtils

object Variance {
	def main(args: Array[String]): Unit = {
		val rdd = SparkUtils.sparkContent().textFile("data/mydata/variance")
			.map(_.split(" ").map(_.toDouble))
			.map(line => Vectors.dense(line))
		val summary = Statistics.colStats(rdd)
		println("mean:"+summary.mean)
		println("variance:"+summary.variance)
		println("norml1:"+summary.numNonzeros)
		println("norml1:"+summary.normL1)
		println("norml2:"+summary.normL2)
	}
}