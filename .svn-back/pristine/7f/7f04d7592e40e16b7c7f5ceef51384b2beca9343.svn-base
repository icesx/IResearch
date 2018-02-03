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
import org.apache.spark.mllib.linalg.distributed.IndexedRow
import org.apache.log4j.Logger
import org.apache.log4j.Level
import org.apache.spark.mllib.linalg.distributed.BlockMatrix

object MultiplyCollection {
  Logger.getLogger("org").setLevel(Level.OFF)
  def main(args: Array[String]): Unit = {
    val sc = SparkUtils.sparkContent()
    val rdd = sc.textFile("data/mydata/coordination_matrix")
      .map(_.split(" ").map(_.toDouble)).zipWithIndex().map(f => new IndexedRow(f._2, Vectors.dense(f._1)))
    val crm = new IndexedRowMatrix(rdd)
    printBM(crm,2,2)
    printBM(crm,4,4)
  }
  def printBM(crm: IndexedRowMatrix, cn: Int, rn: Int): Unit = {
    var bm = crm.toBlockMatrix(cn, rn)
    bm.blocks.foreach(b => {
      println("b.keys:" + b._1 + ";b.matrix:" + b._2.rowIter.mkString("."))
    })
    println("-------------")
  }
}