package cn.i.xportal.spark.ml.distance

import cn.i.xportal.spark.ml.common.SparkUtils
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.linalg.Vector
import cn.i.xportal.spark.ml.utils.MathUtils

object Euclidean {
	def main(args: Array[String]): Unit = {
		println(MathUtils.euclidean(Array(1, 2, 3, 4).toVector.map(_.toDouble), Array(2, 4, 6, 8).toVector.map(_.toDouble)))
		println(MathUtils.euclidean(Array(1, 2, 3, 4).toVector.map(_.toDouble), Array(5, 6, 7, 8).toVector.map(_.toDouble)))
	}
}