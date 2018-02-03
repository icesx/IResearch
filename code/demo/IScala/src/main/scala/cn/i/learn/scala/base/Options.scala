package cn.i.learn.scala.base

object Options {
	def main(args: Array[String]): Unit = {
		def getProperty(name: String): Option[String] = {
			val value = System.getProperty(name)
			if (value != null) Some(value) else None
		}
		val osName = getProperty("os.name")
		osName match {
			case Some(value) => println(value)
			case _ => println("none")
		}
		println(osName.getOrElse("none"))
		osName.foreach(print _)

	}
}