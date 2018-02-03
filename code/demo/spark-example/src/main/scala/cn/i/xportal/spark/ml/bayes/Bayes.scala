package cn.i.xportal.spark.ml.bayes
import org.apache.spark.mllib.util.MLUtils
import org.apache.spark.{ SparkContext, SparkConf }
import org.apache.spark.mllib.classification.{ NaiveBayes, NaiveBayesModel }
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.regression.LabeledPoint
import cn.i.xportal.spark.ml.common.SparkUtils

object Bayes {
  def main(args: Array[String]) {
    val sc= SparkUtils.sparkContent()
    val data = MLUtils.loadLabeledPoints(sc, "data/mllib/bayes.txt") //读取数据集
    val model = NaiveBayes.train(data, 1.0) //训练贝叶斯模型
    model.labels.foreach(println) //打印label值
    model.pi.foreach(println) //打印先验概率  
  }
}
