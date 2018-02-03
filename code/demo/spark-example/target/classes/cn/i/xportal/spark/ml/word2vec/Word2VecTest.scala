package cn.i.xportal.spark.ml.word2vec;
import org.apache.spark.mllib.feature.Word2Vec
import org.apache.spark.{ SparkConf, SparkContext }
import cn.i.xportal.spark.ml.common.SparkUtils

object Word2VecTest {
  def main(args: Array[String]) {
    val sc = SparkUtils.sparkContent()
    val documents = sc.textFile("data/mydata/word2vec/word2vec").map(_.split(" ").map(_.toLowerCase()).toSeq)
    val word2vec = new Word2Vec().setMinCount(1)
    val model = word2vec.fit(documents)
    println(model.getVectors)
    val synonyms = model.findSynonyms("spark", 12)
    for ((synonym, cosineSimilarity) <- synonyms) {
      println(s"simairy::::$synonym $cosineSimilarity")
    }
  }
}


