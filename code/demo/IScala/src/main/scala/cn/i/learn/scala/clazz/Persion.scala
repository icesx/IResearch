package cn.i.learn.scala.clazz

class Persion(val firstName: String, val lastName: String) {
	private var _age = 0
	def age = _age
	def age_=(newAge: Int) = _age = newAge
	def fullName() = firstName + " " + lastName
	override def toString() = fullName()
}
object run {
	def main(args: Array[String]): Unit = {
		val obama: Persion = new Persion("Barack", "Obama")
		println("Persion: " + obama)
		println("firstName: " + obama.firstName)
		println("lastName: " + obama.lastName)
		obama.age_=(51)
		println("age: " + obama.age)
	}
}