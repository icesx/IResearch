package cn.i.learn.scala.loops

object WhileLoop {
  def main(args: Array[String]) {
    var a = 10;
    while (a < 20) {
      println("Value of a: " + a);
      a = a + 1
    }
    while ({
      val numList = List(1, 2, 3, 4, 5, 6)
      var b = true
      for (a <- numList) {
        println(a == 6)
        if (a == 6) {
          b = false
        }
      }
      b
    }) {
      println("while ");
    }
  }
}