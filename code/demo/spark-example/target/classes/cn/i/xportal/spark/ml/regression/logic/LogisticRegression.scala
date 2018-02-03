package cn.i.xportal.spark.ml.regression.logic
import org.apache.spark.mllib.classification.LogisticRegressionWithSGD
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.{ SparkConf, SparkContext }
import cn.i.xportal.spark.ml.common.SparkUtils

object LogisticRegression {

  def main(args: Array[String]) {
    val data = SparkUtils.sparkContent().textFile("data/mydata/regression/logic/regression")
    val parsedData = data.map(line => {
      val parts = line.split('|')
      LabeledPoint(parts(0).toDouble, Vectors.dense(Array(parts(1)).map(_.toDouble)))
    }).cache()
    val model = LogisticRegressionWithSGD.train(parsedData, 50)
    val target = Vectors.dense(-1) //创建测试值
    val resulet = model.predict(target) //根据模型计算结果
    println(resulet)
  }
}

