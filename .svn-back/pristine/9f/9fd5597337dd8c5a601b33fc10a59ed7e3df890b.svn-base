package cn.i.learn.scala.base

object UnderLint {
    def adder(m: Int, n: Int) = m + n
    def multiply(m: Int)(n: Int): Int = m * n
    def main(args: Array[String]): Unit = {
        val add2 = adder(2, _: Int)
        println(add2(5));
        println(multiply(2)(3))
        val timesTwo = multiply(2) _
        println(timesTwo(3))
    }
}