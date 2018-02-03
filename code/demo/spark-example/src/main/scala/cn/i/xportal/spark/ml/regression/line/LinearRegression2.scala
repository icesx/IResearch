package cn.i.xportal.spark.ml.regression.line;
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.regression.{ LabeledPoint, LinearRegressionWithSGD }
import org.apache.spark.{ SparkConf, SparkContext }

object LinearRegression2 {
  val conf = new SparkConf()
    .setMaster("local")
    .setAppName("LinearRegression2 ")
  val sc = new SparkContext(conf)
  def main(args: Array[String]) {
    val data = sc.textFile("data/mydata/regression/line/line2.txt")
    val parsedData = data.map { line =>
      val parts = line.split('|')
      LabeledPoint(parts(0).toDouble, Vectors.dense(parts(1).split(',').map(_.toDouble)))
    }.cache()
    val model = LinearRegressionWithSGD.train(parsedData, 2, 0.1)
    println(model.weights)
    val result = model.predict(Vectors.dense(3,1300))
    println(result)
  }

}

