package cn.i.xportal.spark.ml.base

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.linalg.distributed.RowMatrix
import cn.i.xportal.spark.ml.common.SparkUtils

object RowMatrixTest {
	def main(args: Array[String]): Unit = {
		val rdd = SparkUtils.sparkContent().textFile("data/mydata/row_matrix")
			.flatMap(_.split(" "))
			.map(_.toDouble)
			.map(line => Vectors.dense(line))
		val rm = new RowMatrix(rdd)
		println(s"rowmaxtrix is $rm")
		println("numRows is "+rm.numRows())
		println("numCols is "+rm.numCols())
	}
}