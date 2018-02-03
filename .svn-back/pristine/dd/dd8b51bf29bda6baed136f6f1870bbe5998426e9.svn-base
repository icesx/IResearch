package cn.i.learn.scala.schems

object Match2 {
	def fibonacci(in: Any): Int = in match {
		case 0 => 0
		case 1 => 1
		case n: Int => fibonacci(n - 1) + fibonacci(n - 2)
		case _ => 0
	}
	def main(args: Array[String]): Unit = {
		println(fibonacci(3))
	}
}