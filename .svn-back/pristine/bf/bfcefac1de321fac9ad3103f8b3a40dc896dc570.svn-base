
package cn.i.xportal.spark.ml.countvector

import org.apache.spark.ml.feature.{ CountVectorizer, CountVectorizerModel }
import org.apache.spark.sql.SparkSession
import org.apache.log4j.Logger
import org.apache.log4j.Level
import cn.i.xportal.spark.ml.common.SparkUtils
import org.apache.spark.ml.feature.IDF
import org.apache.spark.sql.Dataset
import org.apache.spark.sql.Row
import org.apache.spark.ml.linalg.SparseVector
import scala.collection.JavaConversions._
object CountVectorizerIDF {
  Logger.getLogger("org").setLevel(Level.OFF)
  def main(args: Array[String]) {
    val spark = SparkUtils.sparkSession()
    val df: Dataset[Row] = spark.createDataFrame(Seq(
      (0, Array("g", "b", "c")),
      (1, Array("a", "b", "c", "b", "a")),
      (2, Array("a", "d", "e", "f"))))
      .toDF("id", "words")
    val cvModel: CountVectorizerModel = new CountVectorizer()
      .setInputCol("words")
      .setOutputCol("count")
      .setMinDF(1)
      .fit(df)
    val tf = cvModel.transform(df)
    val vocabs = cvModel.vocabulary
    val idf = new IDF().setInputCol("count").setOutputCol("tfidf").fit(tf)
    val tf_idf = idf.transform(tf).select("id", "tfidf")
    tf_idf.show(false)
    tf_idf
      .rdd.map { x =>
        val sv = x.get(1).asInstanceOf[SparseVector]
        sv.indices.zip(sv.values).map(x => (vocabs(x._1), x._2)).sortBy(-_._2)
      }
      .foreach(x => {
        println(x.mkString(","))
      })
    spark.stop()
  }
}


