package cn.i.learn.scala.function

import scala.reflect.io.File
import java.util.Scanner
//借贷模式
//由于函数可以像值一样作为参数传递，所以可以方便的实现借贷模式。
//
//这个例子是从/proc/self/stat文件中读取当前进程的pid。
//
//withScanner封装了try-finally块，所以调用者不用再close。
//
//注：当表达式没有返回值时，默认返回Unit。
object FunctionCallBack {
  def withScanner(f: File, op: Scanner => Unit) = {
    val scanner = new Scanner(f.bufferedReader)
    try {
      op(scanner)
    } finally {
      scanner.close()
    }
  }
  def main(args: Array[String]): Unit = {
    withScanner(File("/proc/self/stat"),
      scanner => println("pid is " + scanner.next()))
  }
}