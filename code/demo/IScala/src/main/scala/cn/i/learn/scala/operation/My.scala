package cn.i.learn.scala.operation

object My {
  class Foo {
    def ^-^(v: String) = "^-^ " + v
  }
  def main(args: Array[String]): Unit = {
    val foo = new Foo()
    foo ^-^ "foobar"
  }
}