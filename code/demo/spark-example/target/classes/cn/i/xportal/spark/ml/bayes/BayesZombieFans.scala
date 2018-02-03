package cn.i.xportal.spark.ml.bayes

import cn.i.xportal.spark.ml.common.SparkUtils
import org.apache.spark.mllib.classification.NaiveBayes
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.regression.LabeledPoint

/**
 * V=(v1,v2,v3)
 * v1=已发微博/注册天数;<0.05 v1=0;<0.75=1,>=0.75=2
 * v2=好友数量/注册天数;<0.05 v1=0;<0.75=1,>=0.75=2
 * v3=是否有手机 是=1,否=0
 * @author i
 *
 */
object BayesZombieFans {
  def main(args: Array[String]): Unit = {
    val sc = SparkUtils.sparkContent()
    val file = sc.textFile("data/mllib/bayes/zombieFans.txt") //读取数据集
    val data = file.map { line =>
      val parts = line.split(',') //分割数据
      LabeledPoint(parts(0).toDouble, //标签数据转换
        Vectors.dense(parts(1).split(' ').map(_.toDouble))) //向量数据转换
    }
    val splits = data.randomSplit(Array(0.7, 0.3), seed = 11L) //对数据进行分配
    val trainingData = splits(0) //设置训练数据
    val testData = splits(1) //设置测试数据
    val model = NaiveBayes.train(trainingData, lambda = 1.0) //训练贝叶斯模型
    val predictionAndLabel = testData.map(p => (model.predict(p.features), p.label)) //验证模型
    val accuracy = 1.0 * predictionAndLabel.filter( //计算准确度
      label => label._1 == label._2).count() //比较结果
    println(accuracy) //打印准确度
  }
}