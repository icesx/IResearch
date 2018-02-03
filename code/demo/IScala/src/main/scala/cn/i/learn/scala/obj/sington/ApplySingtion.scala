package cn.i.learn.scala.obj.sington

class ApplySingtion {
  private val name = "apply"
  def say() = {
    println(this + ":" + name)
  }
}
object ApplySington {
  private var as: ApplySingtion = null
  def apply() = {
    as = if (as == null) new ApplySingtion() else as
    as
  }

  def main(args: Array[String]): Unit = {
    (0 to 10).toList.foreach(x =>
      ApplySington().say())

  }
}

