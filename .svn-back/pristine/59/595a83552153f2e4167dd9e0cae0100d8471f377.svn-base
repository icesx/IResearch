package cn.i.xportal.spark.ml.tfidf;
import org.apache.spark.mllib.feature.{ IDF, HashingTF }
import org.apache.spark.{ SparkContext, SparkConf }
import cn.i.xportal.spark.ml.common.SparkUtils
import org.apache.log4j.Logger
import org.apache.log4j.Level

object TF_IDF {
  Logger.getLogger("org").setLevel(Level.OFF)
  def main(args: Array[String]) {
    val sc = SparkUtils.sparkContent()
    val documents = sc.textFile("data/mydata/tf-idf/tf-idf").map(_.split(" ").toSeq)
    val hashingTF = new HashingTF()
    val tf = hashingTF.transform(documents).cache()
    val idf = new IDF().fit(tf)
    val tf_idf = idf.transform(tf)
    tf_idf.foreach(println)

  }
}
