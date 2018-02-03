package cn.i.xportal.spark.graphx

import cn.i.xportal.spark.ml.common.SparkUtils
import org.apache.spark.graphx.GraphLoader

object StrongConnectedCompoentsBase {
  def main(args: Array[String]): Unit = {
    val sc = SparkUtils.sparkContent()
    val graph = GraphLoader.edgeListFile(sc, "data/graphx/followers.txt")
    // Find the connected components
    val cc = graph.stronglyConnectedComponents(10).vertices 
    println(cc.collect().mkString("\n"))
    val ct = graph.connectedComponents().triplets
    ct.foreach(f => {
      println(f.srcId + "->" + f.dstId + ";srcAttr:" + f.srcAttr + ";dstAttr:" + f.dstAttr + ";attr:" + f.attr)
    })
    println(ct.collect().mkString("\n"))
  }
}