package cn.i.xportal.spark.graphx

import org.apache.spark.rdd.RDD
import org.apache.spark.graphx.Graph
import org.apache.spark.graphx.Edge
import cn.i.xportal.spark.ml.common.SparkUtils
import org.apache.spark.graphx.{ Graph, VertexId }
object Triplets {
  def main(args: Array[String]): Unit = {
    val sc = SparkUtils.sparkContent()
    val users: RDD[(VertexId, Double)] =
      sc.parallelize(Array(
        (1L, 10.0),
        (4L, 40.0),
        (3L, 30.0),
        (7L, 70.0),
        (5L, 50.0),
        (2L, 20.0)))
    val relationships: RDD[Edge[Double]] =
      sc.parallelize(Array(
        Edge(3L, 7L, 1.1),
        Edge(3L, 5L, 1.2),
        Edge(5L, 3L, 1.3),
        Edge(2L, 5L, 1.4),
        Edge(7L, 4L, 1.5),
        Edge(3L, 1L, 1.6),
        Edge(5L, 7L, 1.7)))
    val g = Graph(users, relationships)
    g.triplets.foreach(f => {
      println(f.srcAttr + "," + f.dstAttr + "," + f.attr)
    })
    g.edges.foreach(f => {
      println(f.srcId+","+f.dstId+","+f.attr)
    })
  }
}