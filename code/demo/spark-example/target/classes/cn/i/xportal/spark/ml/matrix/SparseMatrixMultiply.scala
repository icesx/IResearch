package cn.i.xportal.spark.ml.matrix

import org.apache.spark.mllib.linalg.distributed.CoordinateMatrix
import org.apache.spark.mllib.linalg.distributed.MatrixEntry
import cn.i.xportal.spark.ml.common.SparkUtils
import org.apache.spark.mllib.linalg.distributed.MatrixEntry
import org.apache.log4j.Logger
import org.apache.log4j.Level

object SparseMatrixMultiply {
  Logger.getLogger("org").setLevel(Level.OFF)
  def coordinateMatrixMultiply(leftMatrix: CoordinateMatrix, rightMatrix: CoordinateMatrix): CoordinateMatrix = {
    val M_ = leftMatrix.entries.map({ case MatrixEntry(i, j, v) => (j, (i, v)) })
    val N_ = rightMatrix.entries.map({ case MatrixEntry(j, k, w) => (j, (k, w)) })
    val productEntries = M_
      .join(N_)
      .map({ case (_, ((i, v), (k, w))) => ((i, k), (v * w)) })
      .reduceByKey(_ + _)
      .map({ case ((i, k), sum) => MatrixEntry(i, k, sum) })
    new CoordinateMatrix(productEntries)
  }
  def main(args: Array[String]): Unit = {
    val sc = SparkUtils.sparkContent()
    val rdd = sc.textFile("data/matrix/coordinate")
      .map(_.split(" "))
      .map(v => (v(0).toLong, v(1).toLong, v(2).toLong))
      .map(x => new MatrixEntry(x._1, x._2, x._3))
    val cm = new CoordinateMatrix(rdd)
    SparseMatrixMultiply.coordinateMatrixMultiply(cm, cm).entries.foreach(println)
    println
    cm.toBlockMatrix().multiply(cm.toBlockMatrix()).toCoordinateMatrix().entries.foreach(println)
  }
}