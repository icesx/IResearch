package cn.i.learn.scala.base

object GroupByObj {
    case class persion(name: String, age: Int) {
    }
    def main(args: Array[String]): Unit = {
        val list: List[persion] = (0 to 3).map(i => (persion("xx", i))).toList
        list.groupBy(_.name).foreach(println(_))
        println("--------------------")
        list.groupBy(x => x).foreach(println(_))
    }
}