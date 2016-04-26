package geek4geeks

object BinarySearch extends App {

	def search[T](arr: Array[T], e: T)(implicit ord: Ordering[T]): Int = {
		if (arr.length == 0) return -1

		val mid = arr.length / 2
		if (arr(mid) == e) return mid

		val (left, right) = arr.splitAt(mid)
		if (ord.gt(arr(mid), e)) search(left, e)
		else search(right.tail, e)
	}

	println(search(Array(1, 2, 3, 4, 5), 2))

	assert(search(Array(1, 2, 3, 4, 5, 6, 7, 8, 9), 3) == 2)
	assert(search(Array(1), 3) == -1)
	assert(search(Array(1, 2, 3, 4, 6, 7, 9), 8) == -1)
	assert(search(Array(), 1) == -1)
	assert(search(Array(1, 3, 5, 6, 7, 8, 9), 3) == 1)

}
