package cn.i.xportal.spark.ml.word2vec

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.ml.feature.Word2Vec
import org.apache.log4j.Level
import org.apache.log4j.Logger

object Word2VecTest2 {
  Logger.getLogger("org").setLevel(Level.OFF)
  def main(args: Array[String]) {
    val conf = new SparkConf().setMaster("local").setAppName("")
    val sc = new SparkContext(conf)
    val sqlContext = new org.apache.spark.sql.SQLContext(sc)
    import sqlContext.implicits._
    val documentDF = sqlContext.createDataFrame(Seq(
      "苹果 官网 苹果 宣布 iphone 手机 ipad".split(" "),
      "苹果 梨 香蕉".split(" ")).map(Tuple1.apply)).toDF("text")
    val word2Vec = new Word2Vec()
      .setInputCol("text")
      .setOutputCol("result")
      .setVectorSize(2)
      .setMinCount(1)
    val model = word2Vec.fit(documentDF)
    val result = model.transform(documentDF)
    val fineds = model.findSynonyms("苹果", 2)
    fineds.foreach { x => println(x) }
    result.collect().foreach(println)
  }
}