package cn.i.learn.scala.base

import org.apache.log4j.Logger

object Implict {
    private val logger: Logger = Logger.getLogger(Implict.getClass);
    case class Student(firstName: String, lastName: Option[String] = None)
    def main(args: Array[String]): Unit = {
        logger.info(Student("Foo"))
        logger.info(Student("Foo", None))
        logger.info(Student("Foo", Some("Bar")))
        implicit def string2Option(s: String) = Some(s)
        logger.info(Student("Foo", "Bar"))
    }
}