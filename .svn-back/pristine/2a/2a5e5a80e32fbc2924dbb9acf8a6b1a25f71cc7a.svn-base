package cn.i.learn.scala.function
//按名称传递参数
//这个例子演示了按名称传递参数，由于有除以0，所以运行该程序会产生异常。
//
//试着将
//
//def log(msg: String)
//修改为
//
//def log(msg: => String)
//由按值传递修改为按名称传递后将不会产生异常。
//
//因为log函数的参数是按名称传递，参数会等到实际使用的时候才会计算，所以被跳过。
//
//按名称传递参数可以减少不必要的计算和异常。
object ParmName {
	val logEnable = false

	def log(msg: String) =
		if (logEnable) println(msg)

	val MSG = "programing is running"
	def main(args: Array[String]): Unit = {
		log(MSG + 1 / 0)
	}
}