/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// scalastyle:off println
package cn.i.xportal.spark.graphx

// $example on$
import org.apache.spark.graphx.{ Graph, VertexId }
import org.apache.spark.graphx.util.GraphGenerators
import org.apache.spark.sql.SparkSession
import cn.i.xportal.spark.ml.common.SparkUtils
import org.apache.spark.rdd.RDD
import org.apache.spark.graphx.Edge
import org.apache.spark.SparkContext

/**
 * An example use the Pregel operator to express computation
 * such as single source shortest path
 * Run with
 * {{{
 * bin/run-example graphx.SSSPExample
 * }}}
 */
object SSSPExample {
  def createGraph(sc: SparkContext): Graph[Long, Double] = {
    val users: RDD[(VertexId, Long)] =
      sc.parallelize(Array(
        (1L, 1L),
        (4L, 4L),
        (3L, 3L),
        (7L, 7L),
        (5L, 5L),
        (2L, 2L)))
    val relationships: RDD[Edge[Double]] =
      sc.parallelize(Array(
        Edge(3L, 7L, 1.0),
        Edge(3L, 5L, 1.0),
        Edge(5L, 3L, 1.0),
        Edge(2L, 5L, 1.0),
        Edge(7L, 4L, 1.0),
        Edge(3L, 1L, 1.0),
        Edge(5L, 7L, 1.0)))
    Graph(users, relationships)
  }
  def main(args: Array[String]): Unit = {
    val sc = SparkUtils.sparkContent()

    // $example on$
    // A graph with edge attributes containing distances
    val graph: Graph[Long, Double] = createGraph(sc)
    val sourceId: VertexId = 3 // The ultimate source
    // Initialize the graph such that all vertices except the root have distance infinity.
    val initialGraph = graph.mapVertices((id, _) =>
      if (id == sourceId) 0.0 else Double.PositiveInfinity)
    val sssp = initialGraph.pregel(Double.PositiveInfinity)(
      (id, dist, newDist) => {
        math.min(dist, newDist) // Vertex Program
      },
      triplet => { // Send Message
        if (triplet.srcAttr + triplet.attr < triplet.dstAttr) {
          Iterator((triplet.dstId, triplet.srcAttr + triplet.attr))
        } else {
          Iterator.empty
        }
      },
      (a, b) => {
        math.min(a, b) // Merge Message
      })
    println(sssp.vertices.collect.mkString("\n"))
    // $example off$

    sc.stop()
  }
}
// scalastyle:on println
