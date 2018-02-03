package cn.i.xportal.spark.ml.base

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.mllib.util.MLUtils
import org.apache.spark.rdd.RDD
import org.apache.spark.mllib.regression.LabeledPoint

object LoadLibSVMFile {
	def main(args: Array[String]): Unit = {
		val conf = new SparkConf().setMaster("local").setAppName("SVMFile")
		val sc = new SparkContext(conf)
		val mu: RDD[LabeledPoint] = MLUtils.loadLibSVMFile(sc, "data/mydata/my_svm")
		mu.foreach { println }
	}
}