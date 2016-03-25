package leetcode

import scala.annotation.tailrec

object SwapNodesInPairs extends App {
	def swapInPairs[T](list: List[T]): List[T] = {
		@tailrec
		def aux(list: List[T], acc: List[T]): List[T] = list match {
			case Nil => acc
			case x :: Nil => x :: acc
			case x :: y :: xs => aux(xs, x :: y :: acc)
		}

		aux(list, Nil).reverse
	}

	assert(swapInPairs(List(1, 2, 3, 4, 5)) == List(2, 1, 4, 3, 5))
	assert(swapInPairs(List()) == List())
	assert(swapInPairs(List(1)) == List(1))
	assert(swapInPairs(List(2, 1, 4, 3, 6, 5)) == List(1, 2, 3, 4, 5, 6))
}