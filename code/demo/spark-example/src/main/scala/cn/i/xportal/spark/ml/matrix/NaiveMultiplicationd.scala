package cn.i.xportal.spark.ml.matrix

import breeze.linalg.DenseMatrix

object NaiveMultiplicationd {

  def main(args: Array[String]): Unit = {
    val n = 1000
    var cNormal: DenseMatrix[Double] = DenseMatrix.create(2, 2, Array(0.6, 0.2, 0.4, 0.8))
    val b: DenseMatrix[Double] = DenseMatrix.create(2, 2, Array(0.6, 0.2, 0.4, 0.8))
    for (i <- 0 to 100) {
      val nNormal = cNormal * b
      cNormal.toDenseVector
      cNormal=nNormal
      println(s"Dot product of a and b is \n$cNormal")
    }
  }
}