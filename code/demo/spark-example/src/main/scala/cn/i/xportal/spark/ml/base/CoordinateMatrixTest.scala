package cn.i.xportal.spark.ml.base

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.mllib.linalg.distributed.MatrixEntry
import org.apache.spark.mllib.linalg.distributed.CoordinateMatrix

object CoordinateMatrixTest {
	def main(args: Array[String]): Unit = {
		val conf = new SparkConf().setMaster("local").setAppName("")
		val sc = new SparkContext(conf)
		val rdd = sc.textFile("data/mydata/coordination_matrix")
			.map(_.split(" "))
			.map(vue => (vue(0).toLong, vue(1).toLong, vue(2).toDouble))
			.map(vue => new MatrixEntry(vue._1, vue._2, vue._3))
		val crm = new CoordinateMatrix(rdd)
		crm.entries.foreach(println)
	}
}