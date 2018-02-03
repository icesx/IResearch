package cn.i.xportal.spark.ml.kmeans
import org.apache.spark.mllib.clustering.GaussianMixture
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.{ SparkConf, SparkContext }
import cn.i.xportal.spark.ml.common.SparkUtils

object GMG {
	def main(args: Array[String]) {
		val sc = SparkUtils.sparkContent()
		val data = sc.textFile("data/mydata/kmeans/gmg")
		val parsedData = data.map(s => Vectors.dense(s.trim.split(' ')
			.map(_.toDouble))).cache()
		val model = new GaussianMixture().setK(2).run(parsedData) //训练模型
		for (i <- 0 until model.k) {
			println("weight=%f\nmu=%s\nsigma=\n%s\n" format //逐个打印单个模型
				(model.weights(i), model.gaussians(i).mu, model.gaussians(i).sigma)) //打印结果
		}
	}
}
