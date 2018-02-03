package cn.i.xportal.spark.ml.recommand

import cn.i.xportal.spark.ml.common.SparkUtils
import org.apache.spark.mllib.recommendation.Rating
import org.apache.spark.mllib.recommendation.ALS

object CollaborativeFilter {
	def main(args: Array[String]) {
		val sc = SparkUtils.sparkContent()
		val data = sc.textFile("data/mydata/recommand/als")
		val ratings = data.map(_.split(' ') match {
			case Array(user, item, rate) => //将数据集转化
				Rating(user.toInt, item.toInt, rate.toDouble) //将数据集转化为专用Rating
		})
		val rank = 2 //设置隐藏因子
		val numIterations = 5 //设置迭代次数
		val model = ALS.train(ratings, rank, numIterations, 0.01) //进行模型训练
		var rs = model.recommendProducts(2, 1) //为用户2推荐一个商品
		rs.foreach(println) //打印结果
	}
}