package cn.i.learn.scala.base

class GroupBy[T] {
    def groupById(array: List[(String, Iterable[T])]): List[(String, Iterable[T])] = {
        array.groupBy(_._1).map(f => {
            (f._1, { f._2.reduceLeft((a, b) => (a._1, b._2.++:(a._2)))._2 })
        }).toList
    }
}
object GroupBy {
    def main(args: Array[String]): Unit = {
        var array: List[(String, Iterable[String])] = List(("0", Iterable("01", "02")), ("0", Iterable("03", "04")), ("1", Iterable("11", "12", "13")))
        array.foreach(println)
        println("------------------")
        array.groupBy(_._1).foreach(_._2.foreach(println))
        println("------------------")
        new GroupBy[String]().groupById(array).foreach(println)
        println("------------------")
        var list=List(("0", Iterable(("01", 1), ("02", 3))), ("0", Iterable(("01", 3), ("04", 1))), ("1", Iterable(("11", 2), ("12", 3), ("13", 2))))
        val newList = new GroupBy[(String, Int)]().groupById(list)
        newList.foreach(println)
    }
}