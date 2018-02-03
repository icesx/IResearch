package cn.i.learn.scala.function

object Method {
	def square(a: Int) { a * a }
	def square2(a: Int) = {
		a * a
	}
	def main(args: Array[String]): Unit = {
		println("square(2):" + square(2))
		println("sequre(2):" + square2(2))
		var x = (a: Int) => { a * a }
		println("sequre(2):" + x(2))
		println("sequre(2):" + { a: Int => a * a })
	}
}