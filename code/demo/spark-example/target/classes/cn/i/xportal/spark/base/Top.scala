package cn.i.xportal.spark.base

import cn.i.xportal.spark.ml.common.SparkUtils
import org.apache.log4j.Level
import org.apache.log4j.Logger

object Top {
  Logger.getLogger("org").setLevel(Level.OFF)
  def main(args: Array[String]): Unit = {
    val sc = SparkUtils.sparkContent()
    val rdd1 = sc.parallelize(Seq(("A", 2), ("B", 3), ("C", 3), ("C", 1), ("d", 0)))
    rdd1
      .sortBy(_._2)
      .foreach(println)
    println("sortBy->")
    /**
     * *
     * sortBy 后的 top 获取的有我问题
     * **
     */
    println("sortBy top not work->")
    rdd1
      .sortBy(_._2)
      .top(5)
      .foreach(println)
    println("Ordering->")
    rdd1.top(5)(Ordering[(Int)].on(x => x._2))
      .foreach(println)
    println("sortByKey->")
    rdd1
      .map(x => (x._2, x._1))
      .sortByKey()
      .top(5)
      .foreach(println)
  }
}