package cn.i.xportal.spark.ml.regression.line

import org.apache.spark.mllib.regression.LinearRegressionWithSGD
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.regression.LabeledPoint

object LinearMe {

  /**
   * y=2x+1
   * @param args
   */
  def main(args: Array[String]) {
    val conf = new SparkConf()
      .setMaster("local")
      .setAppName("LinearRegression ")
    val sc = new SparkContext(conf)
    val data = sc.textFile("data/mydata/regression/line/line-me.txt")
    val parsedData = data.map { line =>
      val parts = line.split(',')
      LabeledPoint(parts(0).toDouble, Vectors.dense(parts(1).toDouble))
    }.cache()
    val model = LinearRegressionWithSGD.train(parsedData, 100, 0.1)
    println(model.weights)
    val result = model.predict(Vectors.dense(3)) //通过模型预测模型
    println(result) //打印预测结果
  }

}