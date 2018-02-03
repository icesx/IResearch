package cn.i.learn.scala.mytrait

trait Same {
  def <(that: String): Boolean
  def <=(that: String): Boolean = (this < that) || (this.equals(that))
  def >(that: String): Boolean = !(this <= that)
  def >=(that: String): Boolean = !(this < that)
}