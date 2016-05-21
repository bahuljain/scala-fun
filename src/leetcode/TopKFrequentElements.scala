package leetcode

import scala.collection.mutable.PriorityQueue
import scala.util.{ Try, Success, Failure }

object TopKFrequentElements extends App {
	def topK(arr: Array[Int], k: Int) = Try {

		// obtaining the frequency of each element
		val countMap = arr.groupBy(identity).mapValues(_.length).toList

		// using heap sort O(klogn) time can be achieved
		// takes O(n) time to build heap and O(log n) to remove an element
		var heap = PriorityQueue[(Int, Int)](countMap: _*)(
			Ordering.by((_: (Int, Int))._2))

		require(k <= heap.length && k >= 0, s"k has to be between 0 and ${heap.length}")

		(for (i <- 1 to k) yield heap.dequeue._1)

		// countMap.sortBy(_._2).reverse.take(k).map(_._1)
	}

	assert(topK(Array(1, 1, 1, 2, 2, 3), 2) == Success(Vector(1, 2)), "1")
	assert(topK(Array(1, 1, 1, 2, 2, 3), 3) == Success(Vector(1, 2, 3)), "2")
	assert(topK(Array(1, 1, 1, 2, 2, 3), 4).isFailure, "3")
	assert(topK(Array(1, 1, 1, 2, 2, 3), -1).isFailure, "4")
	assert(topK(Array(1, 2, 0, 3, 3, 0, 2, 1, 1, 2, 2, 3), 3) == Success(Vector(2, 1, 3)), "5")
	assert(topK(Array(1, 2, 0, 3, 3, 0, 2, 1, 1, 2, 2, 3), 0) == Success(Vector()), "6")
	assert(topK(Array(), 0) == Success(Vector()), "7")

}