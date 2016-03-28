package leetcode

object Permutation extends App {
	def permute[T](list: List[T]): List[List[T]] = {
		list.permutations.toList
	}

	println(permute(List(1, 2, 3, 1)).mkString("\n"))

	/*
	[1,2,3] have the following permutations:
	[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
	*/
}