package leetcode

object RotateList extends App {
	def rotateRight[T](list: List[T], k: Int): List[T] = {
		if (list == Nil) Nil else {
			val (left, right) = list.splitAt(list.length - k % list.length)
			right ::: left
		}
	}

	println(rotateRight(List(1, 2, 3, 4, 5), 2))
	println(rotateRight(Nil, 2))
	println(rotateRight(List(1), 2))
}