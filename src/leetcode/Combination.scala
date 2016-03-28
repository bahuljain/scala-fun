package leetcode

object Combination extends App {
	def combination(n: Int, k: Int) = {
		(1 to n).toList.combinations(k).toList
	}

	//	println(combination(5, 2).mkString("\n"))

	def combinationSum(list: List[Int], target: Int) = {
		for {
			i <- 1 to list.length
			combination <- list.combinations(i).toList
			if (combination.sum == target)
		} yield combination
	}

	println(combinationSum(List(1, 2, 3, 6, 7), 7))

	//	println(List(2, 3, 4, 6).combinations(3).toList)
}