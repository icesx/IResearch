package cn.i.xportal.spark.ml.sampling

import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.stat.Statistics
import org.apache.spark.mllib.linalg.Matrices

object ChiSq {
	/**卡方检验
	 * @param args
	 */
	def main(args: Array[String]): Unit = {
		val vd = Vectors.dense(1, 2, 3, 4, 5)
		val vdResult = Statistics.chiSqTest(vd)
		println(vdResult)
		println("-------------------------------")
		val mtx = Matrices.dense(3, 2, Array(1, 3, 5, 2, 4, 6))
		val mtxResult = Statistics.chiSqTest(mtx)
		println(mtxResult)
	}
}