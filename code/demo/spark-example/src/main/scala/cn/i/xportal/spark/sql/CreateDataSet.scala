package cn.i.xportal.spark.sql

import org.apache.spark.sql.SparkSession
import cn.i.xportal.spark.ml.common.SparkUtils

object CreateDataSet {
  case class Person(name: String, age: Long)
  def main(args: Array[String]): Unit = {
    runDatasetCreationExample(SparkUtils.sparkSession())
  }
  private def runDatasetCreationExample(spark: SparkSession): Unit = {
    import spark.implicits._
    // $example on:create_ds$
    // Encoders are created for case classes
    val caseClassDS = Seq(Person("Andy", 32)).toDS()
    caseClassDS.show()
    // +----+---+
    // |name|age|
    // +----+---+
    // |Andy| 32|
    // +----+---+

    // Encoders for most common types are automatically provided by importing spark.implicits._
    val primitiveDS = Seq(1, 2, 3).toDS()
    primitiveDS.map(_ + 1).show()
    //+-----+
    //|value|
    //+-----+
    //|    2|
    //|    3|
    //|    4|
    //+-----+
    
    // DataFrames can be converted to a Dataset by providing a class. Mapping will be done by name
    val path = "data/sql/people.json"
    spark.read.json(path).as[Person].show()
    // +----+-------+
    // | age|   name|
    // +----+-------+
    // |null|Michael|
    // |  30|   Andy|
    // |  19| Justin|
    // +----+-------+
    // $example off:create_ds$
  }
}