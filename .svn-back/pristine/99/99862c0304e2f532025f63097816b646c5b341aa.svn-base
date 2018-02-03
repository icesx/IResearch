package cn.i.learn.scala.function

class FunctionT[T] {
    var t: T = _
    def f(fc: (T) => Unit): Unit = {
        fc(t)
    }
    def f2(t: T, fc: (T) => Unit) = {
        fc(t)
    }
}
object FunctionT {
    def main(args: Array[String]): Unit = {
        val func: FunctionT[String] = new FunctionT
        func.t = "xxxxx"
        func.f(x => (println(x)))
        func.f2("y", println)
    }
}