package cn.i.xportal.spark.ml.scaler

import cn.i.xportal.spark.ml.common.SparkUtils
import org.apache.spark.ml.linalg.Vectors
import org.apache.spark.ml.feature.Normalizer
import org.apache.log4j.Logger
import org.apache.log4j.Level
import org.apache.spark.sql.DataFrame
import org.apache.spark.ml.feature.StandardScaler
import org.apache.spark.ml.feature.MinMaxScaler
import org.apache.spark.ml.feature.MaxAbsScaler

object Scalers {
  Logger.getLogger("org").setLevel(Level.OFF)
  def normalizer(df: DataFrame) = {
    val normalizer = new Normalizer()
      .setInputCol("features")
      .setOutputCol("normFeatures")
      .setP(1.0)

    val l1NormData = normalizer.transform(df)
    println("Normalized using L^1 norm")
    l1NormData.show()
  }
  def standard(df: DataFrame) = {
    val scaler = new StandardScaler()
      .setInputCol("features")
      .setOutputCol("standardFeatures")
      .setWithStd(true)
      .setWithMean(false)

    // Compute summary statistics by fitting the StandardScaler.
    val scalerModel = scaler.fit(df)

    // Normalize each feature to have unit standard deviation.
    val scaledData = scalerModel.transform(df)
    scaledData.show(truncate = false)

  }
  def minmax(df: DataFrame) = {
    val scaler = new MinMaxScaler()
      .setInputCol("features")
      .setOutputCol("minmaxFeatures")

    // Compute summary statistics and generate MinMaxScalerModel
    val scalerModel = scaler.fit(df)

    // rescale each feature to range [min, max].
    val scaledData = scalerModel.transform(df)
    println(s"Features scaled to range: [${scaler.getMin}, ${scaler.getMax}]")
    scaledData.select("features", "minmaxFeatures").show(truncate = false)
  }
  def avarg(df: DataFrame) = {
    val scaler = new MaxAbsScaler()
      .setInputCol("features")
      .setOutputCol("avargFeatures")

    // Compute summary statistics and generate MaxAbsScalerModel
    val scalerModel = scaler.fit(df)

    // rescale each feature to range [-1, 1]
    val scaledData = scalerModel.transform(df)
    scaledData.select("features", "avargFeatures").show(truncate = false)

  }
  def main(args: Array[String]): Unit = {
    val ss = SparkUtils.sparkSession()
    val dataFrame = ss.createDataFrame(Seq(
      (0, Vectors.dense(1.0, 0.5, -1.0)),
      (1, Vectors.dense(2.0, 1.0, 1.0)),
      (2, Vectors.dense(4.0, 10.0, 2.0)))).toDF("id", "features")
    dataFrame.show
    normalizer(dataFrame)
    standard(dataFrame)
    minmax(dataFrame)
    avarg(dataFrame)
  }
}