package cn.i.learn.scala.clazz

import scala.reflect.ClassTag

class RunTimeClass[T: ClassTag] {
    def clazz[T: ClassTag](x: String) {
        println(implicitly[ClassTag[T]].runtimeClass + ":" + x)
    }
}
object test {
    def main(args: Array[String]): Unit = {
        new RunTimeClass[String].clazz[String]("string me!");
    }
}