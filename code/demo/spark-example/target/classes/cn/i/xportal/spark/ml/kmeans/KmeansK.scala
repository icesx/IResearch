package cn.i.xportal.spark.ml.kmeans

import org.apache.log4j.Logger
import org.apache.spark.mllib.clustering.KMeans
import org.apache.spark.mllib.clustering.KMeansModel
import org.apache.spark.mllib.linalg.Vectors

import cn.i.xportal.spark.ml.common.SparkUtils
import org.apache.log4j.Level

object KmeansK {
  Logger.getLogger("org").setLevel(Level.OFF)
  /***
   * 从上图的运行结果可以看到，当 K=9 时，
   *
   *  cost 值有波动，但是后面又逐渐减小了，所以我们选择 8 这个临界点作为 K 的个数。
   *  当然可以多跑几次，找一个稳定的 K 值。理论上 K 的值越大，聚类的 cost 越小，
   *  极限情况下，每个点都是一个聚类，这时候 cost 是 0，但是显然这不是一个具有实际意义的聚类结果
   */
	def main(args: Array[String]): Unit = {
		val keys: Array[Int] = Array(3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20)
		val parsedTrainingData = SparkUtils.sparkContent().parallelize(Array("1,2,3", "6,2,3", "7,9,3"))
			.map(r => (Vectors.dense(r.split(",").map(_.toDouble))))
		keys.foreach(cluster => {
			val model: KMeansModel = KMeans.train(parsedTrainingData, cluster, 30)
			val ssd = model.computeCost(parsedTrainingData)
			println("sum of squared distances of points to their nearest center when k=" + cluster + " -> " + ssd)
		})
	}
}