package cn.i.xportal.spark.ml.lda
import org.apache.spark.sql.SparkSession
import org.apache.spark.rdd.RDD
import cn.i.xportal.spark.ml.common.SparkUtils
import scala.collection.mutable
import org.apache.spark.mllib.clustering.LDA
import org.apache.spark.mllib.linalg.{ Vector, Vectors }
import org.apache.spark.rdd.RDD
import scala.collection.mutable.HashMap

object LDAExample {
  def main(args: Array[String]): Unit = {
    val sc = SparkUtils.sparkContent()
    val corpus: RDD[String] = sc.wholeTextFiles("data/mydata/lda/*.md").map(_._2)
    // Split each document into a sequence of terms (words)
    val tokenized: RDD[Seq[String]] =
      corpus.map(_.toLowerCase.split("\\s")).map(_.filter(_.length > 3).filter(_.forall(java.lang.Character.isLetter)))
    // Choose the vocabulary.
    //   termCounts: Sorted list of (term, termCount) pairs
    val termCounts: Array[(String, Long)] =
      tokenized.flatMap(_.map(_ -> 1L)).reduceByKey(_ + _).collect().sortBy(-_._2)
    //   vocabArray: Chosen vocab (removing common terms)
    val numStopwords = 20
    val vocabArray: Array[String] =
      termCounts.takeRight(termCounts.size - numStopwords).map(_._1)
    //   vocab: Map term -> term index
    val vocab: Map[String, Int] = vocabArray.zipWithIndex.toMap

    // Convert documents into term count vectors
    val documents: RDD[(Long, Vector)] =
      tokenized.zipWithIndex.map {
        case (tokens, id) =>
          val counts = new HashMap[Int, Double]()
          tokens.foreach { term =>
            if (vocab.contains(term)) {
              val idx = vocab(term)
              counts(idx) = counts.getOrElse(idx, 0.0) + 1.0
            }
          }
          (id, Vectors.sparse(vocab.size, counts.toSeq))
      }

    // Set LDA parameters
    val numTopics = 10
    val lda = new LDA().setK(numTopics).setMaxIterations(10)

    val ldaModel = lda.run(documents)
    // Print topics, showing top-weighted 10 terms for each topic.
    val topicIndices = ldaModel.describeTopics(maxTermsPerTopic = 10)
    topicIndices.foreach {
      case (terms, termWeights) =>
        println("TOPIC:")
        terms.zip(termWeights).foreach {
          case (term, weight) =>
            println(s"${vocabArray(term.toInt)}\t$weight")
        }
        println()
    }
  }
}