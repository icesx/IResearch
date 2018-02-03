package cn.i.xportal.spark.ml.sampling

import cn.i.xportal.spark.ml.common.SparkUtils

object StratifiedSampling {
	def main(args: Array[String]): Unit = {
		val data = SparkUtils.sparkContent().makeRDD(Array(
			("female", "Lily"),
			("female", "Lucy"),
			("female", "Emily"),
			("female", "Kate"),
			("female", "Alice"),
			("male", "Tom"),
			("male", "Roy"),
			("male", "David"),
			("male", "Frank"),
			("male", "Jack")))
		/**
		 * fractions 参数被定义成一个 Map[K, Double] 类型，Key是键值的分层条件，
		 * Double 是该满足条件的 Key 条件的采样比例，1.0 代表 100%。
		 */
		val fractions: Map[String, Double] = Map("female" -> 0.6, "male" -> 0.4)
		val approxSample = data.sampleByKey(withReplacement = false, fractions, 1)
		approxSample.foreach(println)
	}
}