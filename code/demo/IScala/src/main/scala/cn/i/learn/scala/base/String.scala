package cn.i.learn.scala.base

object String {
  def main(args: Array[String]): Unit = {
    val str = "abcdadsfadfjpajdsfadfadsfadjoadsfadf"
    var time = System.currentTimeMillis()
    val max = 10000000
    for (i <- 0 to max) {
      str.replace('a', '-')
    }
    println((System.currentTimeMillis() - time) + "ms")
    time = System.currentTimeMillis()
    for (i <- 0 to max) {
      str.map(x => if (x == 'a') '-' else x)
    }
    println((System.currentTimeMillis() - time) + "ms")
  }
}