package cn.i.learn.scala.schems

object Match {
    def optionWithPM() = {
        val footballTeamsAFCEast =
            Map("New England" -> "Patriots",
                "New York" -> "Jets",
                "Buffalo" -> "Bills",
                "Miami" -> "Dolphins")
        def show(value: Option[String]) = {
            value match {
                case Some(x) => x
                case None => "No team found"
            }
        }
        show(footballTeamsAFCEast.get("Miami"))
    }
    def main(args: Array[String]): Unit = {
        println(optionWithPM)
    }
}