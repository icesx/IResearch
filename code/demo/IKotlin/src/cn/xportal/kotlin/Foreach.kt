package cn.xportal.kotlin

object Foreach {
	fun testForeache() {
		(1..3).iterator().forEach {
			println("The element is $it")
		}
	}
}

fun main(args: Array<String>) {
	Foreach.testForeache()
}