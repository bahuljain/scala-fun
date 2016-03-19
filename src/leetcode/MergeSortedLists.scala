package leetcode

object MergeSortedLists extends App {
	def merge[T](list1: List[T], list2: List[T])(implicit ord: Ordering[T]): List[T] =
		(list1, list2) match {
			case (Nil, list2) => list2
			case (list1, Nil) => list1
			case (x :: xs, y :: ys) =>
				if (ord.lt(x, y)) x :: merge(xs, y :: ys)
				else y :: merge(x :: xs, ys)
		}

	println(merge(List(1, 3, 5, 7, 9), List(2, 4, 6, 8, 10)))
	assert(merge(List(), List(1)) == List(1))
	assert(merge(List("a"), List("b")) == List("a", "b"))
	assert(merge(List(2.5), List()) == List(2.5))
	assert(merge(List(-1.0, 0.4, 2.1, 3.2), List(1.1, 2.0, 3.1)) == List(-1.0, 0.4, 1.1, 2.0, 2.1, 3.1, 3.2))
}