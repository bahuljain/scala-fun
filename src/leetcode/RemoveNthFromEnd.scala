package leetcode

object RemoveNthFromEnd extends App {
	def removeNth[T](list: List[T], n: Int) = {
		val (front, back) = list.splitAt(list.length - n)
		front ++ back.tail
	}

	println(removeNth(List(1, 2, 3, 4, 5, 6, 7, 8), 4))
}