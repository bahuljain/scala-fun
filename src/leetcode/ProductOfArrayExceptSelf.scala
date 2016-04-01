package leetcode

import scala.annotation.tailrec

object ProductOfArrayExceptSelf extends App {
	def productSelf(list: List[Int]): List[Int] = {
		@tailrec
		def aux(list: List[Int], acc: List[Int]): List[Int] = list match {
			case Nil => acc
			case x :: xs => aux(xs, x * acc.head :: acc)
		}

		val front = aux(list, List(1)).tail.reverse
		val back = aux(list.reverse, List(1)).tail

		(front zip back).map(e => e._1 * e._2)
	}

	println(productSelf(List(2, 2, 0, 4)))
	println(productSelf(List(1, 4, 2, 3, 5, 2)))
}