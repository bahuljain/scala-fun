package leetcode

object PartitionList extends App {
	def partition(list: List[Int], x: Int): List[Int] = {
		val (left, right) = list partition (y => y <= x)
		left ++ right
	}

	println(partition(List(1, 4, 3, 2, 5, 2), 2))
}