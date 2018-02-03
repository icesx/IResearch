package cn.i.xportal.spark.ml.tfidf

import cn.i.xportal.spark.ml.common.SparkUtils
import org.apache.log4j.Level
import org.apache.log4j.Logger

object MyTFIDF {
  Logger.getLogger("org").setLevel(Level.OFF)
  def main(args: Array[String]) {
    val spark = SparkUtils.sparkSession()
    val df = spark.sparkContext.parallelize(Seq(
      (0, Array("a", "b", "c")),
      (1, Array("a", "b", "c", "b", "a")),
      (2, Array("a", "d", "e", "f"))))
    val wordLookup = df.map(_._2)
      .flatMap(x => x)
      .distinct()
      .zipWithIndex()
    wordLookup.foreach(println)
    
    spark.stop()
  }
}