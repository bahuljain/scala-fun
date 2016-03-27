package leetcode

object ReorderList extends App {
	def reorder[T](list: List[T]): List[T] = {
		def merge(l1: List[T], l2: List[T]): List[T] = (l1, l2) match {
			case (Nil, _) => Nil
			case (x, Nil) => x
			case (x :: xs, y :: ys) => x :: y :: merge(xs, ys)
		}

		if (list == Nil) Nil else {
			val mid: Int = (list.length.toDouble / 2).ceil.toInt
			val (left, right) = list.splitAt(mid)
			merge(left, right.reverse)
		}
	}

	println(reorder(List(1, 2, 3, 4, 5, 6, 7, 8, 9)))
	println(reorder(List()))
	println(reorder(List(1)))
	println(reorder(List(1, 3, 5, 7, 9, 8, 6, 4, 2)))
}