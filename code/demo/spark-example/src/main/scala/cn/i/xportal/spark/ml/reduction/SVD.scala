package cn.i.xportal.spark.ml.reduction;
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.linalg.distributed.RowMatrix
import org.apache.spark.{ SparkConf, SparkContext }
import cn.i.xportal.spark.ml.common.SparkUtils

object SVD {
	def main(args: Array[String]) {
		val sc = SparkUtils.sparkContent()
		val data = sc.textFile("data/mydata/reduction/svg")
			.map(_.split(' ')
				.map(_.toDouble))
			.map(line => Vectors.dense(line))
		val rm = new RowMatrix(data) //读入行矩阵
		val SVD = rm.computeSVD(2, computeU = true) //进行SVD计算
		println("U:"+SVD.U)
		println("s:"+SVD.s)
		println("V:"+SVD.V)
	}
}

