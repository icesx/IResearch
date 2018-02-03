package cn.i.learn.scala.list

object ListSample {
    def main(args: Array[String]): Unit = {
        val oneTwo = List(1, 2)
        val threeFour = List(3, 4)
        val oneTwooneTwoThreeFour = oneTwo ::: threeFour
        println(oneTwo + " and " + threeFour + " were not mutated.")
        println("Thus, " + oneTwooneTwoThreeFour + " is a new List.")
        val twoThree = List(2, 3)
        val oneTwoThree = 1 :: twoThree
        println(oneTwoThree)
        val oneTwoThree2 = 1 :: 2 :: 3 :: Nil
        println(oneTwoThree2)
        println((1 to 10).toList)
    }
}