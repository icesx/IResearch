package cn.i.xportal.spark.ml.distance

import cn.i.xportal.spark.ml.common.SparkUtils
import cn.i.xportal.spark.ml.utils.MathUtils

object Cosine {
	def main(args: Array[String]): Unit = {
		val u1 = Map("smzdm" -> 2, "ylxb" -> 3, "znh" -> 1, "nhsc" -> 0, "fcwr" -> 1)
		val u2 = Map("smzdm" -> 1, "ylxb" -> 2, "znh" -> 2, "nhsc" -> 1, "fcwr" -> 4)
		println(MathUtils.consine(u1.values.toVector.map(_.toDouble), u2.values.toVector.map(_.toDouble)))
	}
}