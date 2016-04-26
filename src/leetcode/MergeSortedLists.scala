package leetcode

import scala.annotation.tailrec

object MergeSortedLists extends App {

	// Not tail recursive, hence not efficient.
	def merge[T](list1: List[T], list2: List[T])(implicit ord: Ordering[T]): List[T] =
		(list1, list2) match {
			case (Nil, list2) => list2
			case (list1, Nil) => list1
			case (x :: xs, y :: ys) =>
				if (ord.lt(x, y)) x :: merge(xs, y :: ys)
				else y :: merge(x :: xs, ys)
		}

	def merge2[T](list1: List[T], list2: List[T])(implicit ord: Ordering[T]): List[T] = {
		@tailrec
		def aux(l1: List[T], l2: List[T], acc: List[T]): List[T] = (l1, l2) match {
			case (Nil, Nil) => acc
			case (x :: xs, Nil) => aux(xs, l2, x :: acc)
			case (Nil, x :: xs) => aux(l1, xs, x :: acc)
			case (x :: xs, y :: ys) if (ord.lt(x, y)) => aux(xs, l2, x :: acc)
			case (x :: xs, y :: ys) => aux(l1, ys, y :: acc)
		}
		aux(list1, list2, Nil).reverse
	}

	println(merge2(List(1, 3, 5, 7, 9), List(2, 4, 6, 8, 10)))
	assert(merge2(List(), List(1)) == List(1))
	assert(merge2(List("a"), List("b")) == List("a", "b"))
	assert(merge2(List(2.5), List()) == List(2.5))
	assert(merge2(List(-1.0, 0.4, 2.1, 3.2), List(1.1, 2.0, 3.1)) == List(-1.0, 0.4, 1.1, 2.0, 2.1, 3.1, 3.2))
}