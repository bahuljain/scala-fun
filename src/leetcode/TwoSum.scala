package leetcode

object TwoSum extends App {
	def twoSum(nums: Array[Int], target: Int) = {
		for {
			i <- 0 until nums.length
			j <- 0 until nums.length
			if (i < j && nums(i) + nums(j) == target)
		} yield (i, j)
	}
	println(twoSum(Array(2, 7, 3, 6), 9))

	def twoSum_++(nums: Array[Int], target: Int) = {
		val map = (for {
			i <- 0 until nums.length
		} yield ((target - nums(i)) -> i)).toMap

		for {
			i <- 0 until nums.length
			if (map.contains(nums(i)))
			if (i < map(nums(i)))
		} yield (i, map(nums(i)))
	}
	println(twoSum_++(Array(2, 5, 0, 7, 1, 3, 6), 9))

	def twoSum_+(nums: Array[Int], target: Int) = {
		def aux(nums: List[(Int, Int)], map: Map[Int, Int]): Option[(Int, Int)] = nums match {
			case Nil => None
			case (i, num) :: tail =>
				if (map.contains(num)) Some(map(num), i)
				else aux(tail, map + ((target - num) -> i))
		}
		aux(((0 to nums.length).toList zip nums), Map())
	}
	println(twoSum_+(Array(2, 5, 0, 7, 1, 3, 6), 9))
}