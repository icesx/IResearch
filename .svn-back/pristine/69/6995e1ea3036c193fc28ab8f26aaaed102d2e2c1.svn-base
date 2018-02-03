package cn.i.xportal.spark.ml.kmeans

import cn.i.xportal.spark.ml.common.SparkUtils
import org.apache.spark.mllib.clustering.KMeans
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.clustering.KMeansModel

object KmeansWork {
	def main(args: Array[String]): Unit = {
		val sc = SparkUtils.sparkContent()
		val data = sc.textFile("data/mydata/kmeans/Wholesale_customers_data.csv")
		val parsedData = data.map(s => Vectors.dense(s.split(",").map(_.toDouble)))
			.cache()
		val numClusters = 2 //最大分类数
		val numIterations = 20 //迭代次数 
		/**
		 * Channel Region Fresh Milk Grocery Frozen Detergents_Paper Delicassen
		 * 2 3
		 * 12669 9656 7561 214 2674 1338
		 * 2 3 7057 9810 9568 1762 3293 1776
		 * 2 3 6353 8808
		 * 7684 2405 3516 7844
		 */

		val rawTrainingData = sc.textFile("data/mydata/kmeans/Wholesale_customers_data.csv")
		val parsedTrainingData =
			rawTrainingData.filter(!isColumnNameLine(_)).map(line => {
				Vectors.dense(line.split(",").map(_.trim).filter(!"".equals(_)).map(_.toDouble))
			}).cache()
		// Cluster the data into two classes using KMeans
		var clusterIndex: Int = 0
		val clusters: KMeansModel =
			KMeans.train(parsedTrainingData, numClusters, numIterations)
		println("Cluster Number:" + clusters.clusterCenters.length)
		println("Cluster Centers Information Overview:")
		clusters.clusterCenters.foreach(
			x => {
				println("Center Point of Cluster " + clusterIndex + ":")
				println(x)
				clusterIndex += 1
			})
		//begin to check which cluster each test data belongs to based on the clustering result
		val rawTestData = sc.textFile("data/mydata/kmeans/Wholesale_customers_data.csv")
		val parsedTestData = rawTestData.map(line => {
			Vectors.dense(line.split(",").map(_.trim).filter(!"".equals(_)).map(_.toDouble))
		})
		parsedTestData.collect().foreach(testDataLine => {
			val predictedClusterIndex: Int = clusters.predict(testDataLine)
			println("The data " + testDataLine.toString + " belongs to cluster " +
				predictedClusterIndex)
		})
		println("Spark MLlib K-means clustering test finished.")
	}

	private def isColumnNameLine(line: String): Boolean = {
		if (line != null &&
			line.contains("Channel")) true
		else false
	}
}