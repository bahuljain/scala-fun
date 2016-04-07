package leetcode

object MoveZeros extends App {
	def moveZeros(nums: List[Int]): List[Int] = {
		val (front, back) = nums.partition(_ != 0)
		front ++ back
	}

	println(moveZeros(List(1, 0, 4, 0, 5, 7, 0, 1)))
}