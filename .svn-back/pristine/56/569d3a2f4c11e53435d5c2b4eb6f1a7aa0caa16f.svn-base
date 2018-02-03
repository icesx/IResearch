package cn.i.xportal.spark.ml.kmeans
import org.apache.spark.mllib.clustering.KMeans
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.{ SparkConf, SparkContext }
import org.apache.spark.mllib.util.MLUtils
import cn.i.xportal.spark.ml.common.SparkUtils

object KmeansTrain {
	def main(args: Array[String]): Unit = {
		val sc = SparkUtils.sparkContent()
		val data = sc.textFile("data/mydata/kmeans/kmeans")
		val parsedData = data.map(s => Vectors.dense(s.split(" ").map(_.toDouble)))
			.cache()
		val numClusters = 2 //最大分类数
		val numIterations = 20 //迭代次数 
		val model = KMeans.train(parsedData, numClusters, numIterations) //训练模型
		model.clusterCenters.foreach(println) 
		
	}
}
