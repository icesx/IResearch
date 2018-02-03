package cn.i.xportal.spark.ml.tfidf;
import org.apache.spark.{ SparkContext, SparkConf }
import cn.i.xportal.spark.ml.common.SparkUtils
import org.apache.log4j.Logger
import org.apache.log4j.Level
import org.apache.spark.ml.feature.HashingTF

object TF {
  Logger.getLogger("org").setLevel(Level.OFF)
  def main(args: Array[String]) {
    val ss = SparkUtils.sparkSession()
    val df = ss.createDataFrame(Seq(
      (0, Array("a", "b", "c")),
      (1, Array("a", "b", "b", "c", "a")),
      (2, Array("a", "c"))))
      .toDF("id", "words")
    val tf = new HashingTF().
      setInputCol("words").
      setOutputCol("tf")

    val tfdf = tf
      .transform(df)

    tfdf.select("id", "tf").
      show(false)
  }
}
