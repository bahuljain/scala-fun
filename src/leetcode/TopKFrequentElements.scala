package leetcode

import scala.collection.breakOut;

object TopKFrequentElements extends App {
	def topK(arr: List[Int], k: Int) = {
		val countMap = arr.groupBy(identity).mapValues(_.length).toList
		countMap.sortBy(_._2).reverse.take(k).map(_._1)
	}

	println(topK(List(1, 1, 1, 2, 2, 3), 2))

}