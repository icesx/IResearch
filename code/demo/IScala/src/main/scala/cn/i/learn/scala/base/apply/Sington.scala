package cn.i.learn.scala.base.apply

class Sington[T](n: String) {
  private val name: String = n
  private var flag: Int = 0;
  def sex(s: T): String = {
    flag += 1
    name + ":" + flag + " ->" + s
  }
}
object Sington {
  private var s: Sington[String] = _
  def apply(n: String) = {
    if (s == null) s = new Sington[String](n)
    s
  }
}
object Test {
  def main(args: Array[String]): Unit = {
    for (i <- 1 to 10) {
      println(Sington("i").sex("man"))
    }
  }
}