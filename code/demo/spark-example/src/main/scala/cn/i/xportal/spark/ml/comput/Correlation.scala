package cn.i.xportal.spark.ml.comput

import org.apache.spark.mllib.stat.Statistics
import cn.i.xportal.spark.ml.common.SparkUtils

object Correlation {
	def main(args: Array[String]): Unit = {
		val sc = SparkUtils.sparkContent()
		val rdd = sc.textFile("data/mydata/corr/x").flatMap(_.split(" ").map(_.toDouble))
		val rddy = sc.textFile("data/mydata/corr/y").flatMap(_.split(" ").map(_.toDouble))
		println("皮尔逊相关系数："+Statistics.corr(rdd, rddy))
		println("斯皮尔曼相关系数："+Statistics.corr(rdd, rddy,"spearman"))
		
	}
}