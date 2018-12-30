package cn.i.xportal.spark.ml.bayes

import cn.i.xportal.spark.ml.common.SparkUtils
import org.apache.spark.mllib.classification.NaiveBayes
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.log4j.Logger
import org.apache.log4j.Level

/**
 * V=(v1,v2,v3)
 * v1=已发微博/注册天数;<0.05 v1=0;<0.75=1,>=0.75=2
 * v2=好友数量/注册天数;<0.05 v1=0;<0.75=1,>=0.75=2
 * v3=是否有手机 是=1,否=0
 * @author i
 *
 */
object BayesZombieFans {
  Logger.getLogger("org").setLevel(Level.OFF)
  def main(args: Array[String]): Unit = {
    val sc = SparkUtils.sparkContent()
    val file = sc.textFile("data/mllib/bayes/zombieFans.txt")
    val data = file.map { line =>
      val parts = line.split(',')
      LabeledPoint(
        parts(0).toDouble,
        Vectors.dense(parts(1).split(' ').map(_.toDouble)))
    }
    val splits = data.randomSplit(Array(0.7, 0.3), seed = 11L)
    val trainingData = splits(0)
    val testData = splits(1)
    val model = NaiveBayes.train(trainingData, lambda = 1.0)
    val predictionAndLabel = testData.map(p => (model.predict(p.features), p.label))
    val accuracy = 1.0 * predictionAndLabel.filter(
      label => label._1 == label._2).count()
    println(accuracy)
  }
}