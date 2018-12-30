package cn.i.xportal.spark.ml.tfidf;
import org.apache.spark.{ SparkContext, SparkConf }
import cn.i.xportal.spark.ml.common.SparkUtils
import org.apache.log4j.Logger
import org.apache.log4j.Level
import org.apache.spark.ml.feature.HashingTF
import org.apache.spark.ml.feature.CountVectorizer
import org.apache.spark.ml.linalg.SparseVector

object TFOnCountVectorizer {
  Logger.getLogger("org").setLevel(Level.OFF)
  def main(args: Array[String]) {
    val ss = SparkUtils.sparkSession()
    val df = ss.createDataFrame(Seq(
      (0, Array("1", "a", "b", "c", "1")),
      (1, Array("a", "b", "b", "c", "a", "1")),
      (2, Array("a", "c"))))
      .toDF("id", "words")
    val tf = new CountVectorizer()
      .setInputCol("words")
      .setOutputCol("tf")
      .setMinDF(1)

    val tfmodle = tf.fit(df)
    val result = tfmodle.transform(df)
    result.select("id", "tf")
      .show(false)
    result.select("id", "tf").rdd.foreach(row => {
      val sv = row(1).asInstanceOf[SparseVector]
      println("indices:" + sv.indices.mkString(","))
      println("values:" + sv.values.mkString(","))
      println("i:v:" + (sv.indices zip sv.values).mkString(","))
    })
    println(tfmodle.vocabulary.mkString(","))
  }
}
