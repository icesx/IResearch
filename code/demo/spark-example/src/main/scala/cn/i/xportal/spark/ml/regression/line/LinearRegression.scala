package cn.i.xportal.spark.ml.regression.line;
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.regression.{ LabeledPoint, LinearRegressionWithSGD }
import org.apache.spark.{ SparkConf, SparkContext }

object LinearRegression {
  val conf = new SparkConf()
    .setMaster("local")
    .setAppName("LinearRegression ")
  val sc = new SparkContext(conf)
  def main(args: Array[String]) {
    val data = sc.textFile("data/mydata/regression/line/line.txt")
    val parsedData = data.map { line =>
      val parts = line.split(',') 
      LabeledPoint(parts(0).toDouble, Vectors.dense(parts(1).split(' ').map(_.toDouble)))
    }.cache()
    //parts(0) is y parts(1) is x1 x2..
    val model = LinearRegressionWithSGD.train(parsedData, 100, 0.1) 
    println(model.weights)
    val result = model.predict(Vectors.dense(2,3)) //通过模型预测模型
    println(result) //打印预测结果
  }

}
