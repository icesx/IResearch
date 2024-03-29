package cn.i.xportal.spark.ml.comput

import org.apache.spark.mllib.stat.Statistics
import org.apache.spark.mllib.linalg.Vectors
import cn.i.xportal.spark.ml.common.SparkUtils

object NormalL2 {
	def main(args: Array[String]): Unit = {
		val scor = Array(1, 2, 3, 4, 1).toVector
		sparkL2(scor)
		l2(scor)
	}
	def sparkL2(scor: Vector[Int]): Unit = {
		val rdd = SparkUtils.sparkContent().parallelize(scor, 1).map(v => Vectors.dense(v))
		val summary = Statistics.colStats(rdd)
		println(summary.normL2)
	}
	def l2(scor: Vector[Int]): Unit = {
		val l2 = math.sqrt(scor.map(num => {
			math.pow(num, 2)
		}).reduce(_ + _))
		println(l2)
	}
}