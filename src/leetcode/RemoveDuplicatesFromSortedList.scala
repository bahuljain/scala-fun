package leetcode

import scala.annotation.tailrec

object RemoveDuplicatesFromSortedList extends App {
	def deleteDuplicates[T](list: List[T]): List[T] = {
		@tailrec
		def aux(list: List[T], prev: T, acc: List[T]): List[T] = list match {
			case Nil => acc
			case x :: xs => if (x == prev) aux(xs, x, acc) else aux(xs, x, x :: acc)
		}

		list match {
			case Nil => Nil
			case x :: xs => aux(xs, x, List(x)).reverse
		}
	}

	assert(deleteDuplicates(List(1, 1, 2, 2, 2, 3, 3, 4, 4, 4, 4, 4, 5)) == List(1, 2, 3, 4, 5))
}