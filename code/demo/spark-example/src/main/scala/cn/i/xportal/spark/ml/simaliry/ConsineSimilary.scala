package cn.i.xportal.spark.ml.simaliry

import cn.i.xportal.spark.ml.common.SparkUtils
import cn.i.xportal.spark.ml.utils.MathUtils

object ConsineSimilary {
	//设置一个用以存放电影分的map
	def getSource(): Map[String, Map[String, Int]] = {
		//设置电影评分
		val user1FilmSource = Map("smzdm" -> 2, "ylxb" -> 3, "znh" -> 1, "nhsc" -> 0, "fcwr" -> 1)
		val user2FilmSource = Map("smzdm" -> 1, "ylxb" -> 2, "znh" -> 2, "nhsc" -> 1, "fcwr" -> 4)
		val user3FilmSource = Map("smzdm" -> 2, "ylxb" -> 1, "znh" -> 0, "nhsc" -> 1, "fcwr" -> 4)
		val user4FilmSource = Map("smzdm" -> 3, "ylxb" -> 2, "znh" -> 0, "nhsc" -> 5, "fcwr" -> 3)
		val user5FilmSource = Map("smzdm" -> 5, "ylxb" -> 3, "znh" -> 1, "nhsc" -> 1, "fcwr" -> 2)
		var source = Map[String, Map[String, Int]]()
		source += ("aaa" -> user1FilmSource)
		source += ("bbb" -> user2FilmSource)
		source += ("ccc" -> user3FilmSource)
		source += ("ddd" -> user4FilmSource)
		source += ("eee" -> user5FilmSource)
		source
	}

	//两两计算分值,采用余弦相似性
	def getCollaborateSource(user1: Map[String, Int], user2: Map[String, Int]): Double = {
		val user1FilmSource = user1.values.toVector.map(_.toDouble) //获得第1个用户的评分
		val user2FilmSource = user2.values.toVector.map(_.toDouble)
		MathUtils.consine(user1FilmSource, user2FilmSource)
	}

	def main(args: Array[String]) {
		val sc = SparkUtils.sparkContent()
		val users = sc.parallelize(Array("aaa", "bbb", "ccc", "ddd", "eee"))
		val films = sc.parallelize(Array("smzdm", "ylxb", "znh", "nhsc", "fcwr")) //设置电影名
		val source = getSource() //初始化分数
		var name = "bbb" //设定目标对象
		users.foreach(user => {
			//迭代进行计算
			println(name + " 相对于 " + user + "的相似性分数是：" + getCollaborateSource(source.get(name).get, source.get(user).get))
		})
		println()
		name = "aaa"
		users.foreach(user => {
			//迭代进行计算
			println(name + " 相对于 " + user + "的相似性分数是：" + getCollaborateSource(source.get(name).get, source.get(user).get))
		})
	}
}