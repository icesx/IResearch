package cn.i.xportal.spark.ml.utils

object MathUtils {
	def consine(scor: Vector[Double], scor2: Vector[Double]): Double = {
		val member = scor.zip(scor2).map(d => d._1 * d._2).reduce(_ + _) //对公式分子部分进行计算
		val denominator = l2(scor) * l2(scor2) //求出分母
		member / denominator
	}
	/**
	 * L2范式元素的平方和然后求平方根
	 * @param scor
	 * @return
	 */
	def l2(scor: Vector[Double]): Double = {
		math.sqrt(scor.map(num => {
			math.pow(num, 2)
		}).reduce(_ + _))
	}
	/**
	 * 开方(x1-x2)^2+(y1-y2)^2
	 * @param x
	 * @param y
	 * @return
	 */
	def euclidean(x: Vector[Double], y: Vector[Double]): Double = {
		math.sqrt(x.zip(y).
			map(p => p._1 - p._2).map(d => d * d).sum)
	}
}