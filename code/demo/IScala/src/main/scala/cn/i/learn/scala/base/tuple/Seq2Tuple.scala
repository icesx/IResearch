package cn.i.learn.scala.base.tuple

object Seq2Tuple {
  def main(args: Array[String]): Unit = {
    val sql = (0 to 21).map(i => (i + "A")).toSeq
    println(toTuple(sql))
  }
  /**
   * 这里:_*用来将集合作为可变参数传递
   * @param as
   * @return
   */
  def toTuple[A <: Object](as: Seq[A]): Product = {
    val tupleClass = Class.forName("scala.Tuple" + as.size)
    tupleClass.getConstructors.apply(0).newInstance(as: _*).asInstanceOf[Product]
  }
}