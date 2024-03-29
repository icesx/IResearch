package cn.i.xportal.spark.ml.matrix

import org.apache.spark.mllib.linalg.Matrix
import org.apache.spark.mllib.linalg.Matrices
import org.apache.spark.mllib.linalg.distributed.IndexedRowMatrix
import cn.i.xportal.spark.ml.common.SparkUtils
import org.apache.derby.impl.sql.execute.IndexRow
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.linalg.distributed.IndexedRow
import org.apache.spark.mllib.linalg.distributed.CoordinateMatrix
import org.apache.spark.mllib.linalg.distributed.MatrixEntry

object Multiply {
  def main(args: Array[String]): Unit = {
    val sc = SparkUtils.sparkContent()
    val rdd = sc.textFile("data/mydata/coordination_matrix")
      .map(_.split(" "))
      .map(vue => (vue(0).toLong, vue(1).toLong, vue(2).toLong))
      .map(vue => new MatrixEntry(vue._1, vue._2, vue._3))
    val crm = new CoordinateMatrix(rdd)
    var bm = crm.toBlockMatrix()
    println(bm.numCols()+"*"+bm.numRows())
    for (i <- 0 to 100) {
      bm = bm.multiply(bm)
    }
  }
}