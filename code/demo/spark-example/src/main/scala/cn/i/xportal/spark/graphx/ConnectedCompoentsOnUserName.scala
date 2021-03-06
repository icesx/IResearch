package cn.i.xportal.spark.graphx

import org.apache.spark.graphx.GraphLoader
import cn.i.xportal.spark.ml.common.SparkUtils

object ConnectedCompoentsOnUserName {
  def main(args: Array[String]): Unit = {
    val sc = SparkUtils.sparkContent()
    val graph = GraphLoader.edgeListFile(sc, "data/graphx/followers.txt")
    // Find the connected components
    val cc = graph.connectedComponents().vertices
    // Join the connected components with the usernames
    println("connectedComponents:"+cc.collect().mkString("\n"))
    val users = sc.textFile("data/graphx/users.txt").map { line =>
      val fields = line.split(",")
      (fields(0).toLong, fields(1))
    }
    val ccByUsername = users.join(cc).map {
      case (id, (username, cc)) => (username, cc)
    }
    // Print the result
    println("join:"+ccByUsername.collect().mkString("\n"))
    val triCounts = graph.triangleCount().vertices
    val triCountByUsername = users.join(triCounts).map {
      case (id, (username, tc)) =>
        (username, tc)
    }
    // Print the result
    println(":"+triCountByUsername.collect().mkString("\n"))
  }
}