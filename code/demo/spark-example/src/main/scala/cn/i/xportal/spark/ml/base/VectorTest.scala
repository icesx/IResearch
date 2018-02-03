package cn.i.xportal.spark.ml.base

import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.linalg.Vector

object VectorTest {
	def main(args: Array[String]): Unit = {
		val v: Vector = Vectors.dense(Array(1D, 2D, 3D))
		println(v(2))
		val vs: Vector = Vectors.sparse(4, Array(1, 2, 3, 4), Array(10D, 12D, 13D, 14D))
		println(vs(2)) 
		println(vs) 
	}
}