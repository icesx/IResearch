package cn.i.xportal.spark.ml.ngram

import org.apache.spark.ml.feature.NGram
import org.apache.spark.sql.SparkSession
import cn.i.xportal.spark.ml.common.SparkUtils
import org.apache.log4j.Level
import org.apache.log4j.Logger

object NGramExample {
  Logger.getLogger("org").setLevel(Level.OFF)
  def main(args: Array[String]): Unit = {
    val spark = SparkUtils.sparkSession()

    // $example on$
    val wordDataFrame = spark.createDataFrame(Seq(
      (0, Array("Hi", "I", "heard", "about", "Spark")),
      (1, Array("I", "wish", "Java", "could", "use", "case", "classes")),
      (2, Array("Logistic", "regression", "models", "are", "neat"))))
      .toDF("id", "words")

    val ngram = new NGram().setN(2).setInputCol("words").setOutputCol("ngrams")

    val ngramDataFrame = ngram.transform(wordDataFrame)
    ngramDataFrame.select("ngrams","id","words").show(false)
    // $example off$

    spark.stop()
  }
}
