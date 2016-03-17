package leetcode

object ContainsDuplicate extends App {
	def containsDuplicate(nums: Array[Int]) =
		(nums.toSet).size == nums.length

	println(containsDuplicate(Array(1, 2, 3, 4, 5, 3, 3, 34, 6, 4, 3, 2)))
	println(containsDuplicate(Array(1, 2, 3, 4, 5, 6)))
}