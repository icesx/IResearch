package cn.i.learn.scala.implici.thread

object ThreadImplici {
    implicit def myRunable(f: () => Unit) = new Runnable() { def run() = f() }
    def main(args: Array[String]): Unit = {
        new Thread(() => println("ok!")).start
    }
}