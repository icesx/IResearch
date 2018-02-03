package cn.i.xportal.spark.ml.vector

import org.apache.spark.ml.linalg.Vectors

object DenseSparseVector {
  def main(args: Array[String]): Unit = {
    val dv = Vectors.dense(2, 0, 6)
    println(dv)
    val pv = Vectors.sparse(8, Array(0, 4, 7), Array(1, 2, 3))
    println(pv)
  }
}