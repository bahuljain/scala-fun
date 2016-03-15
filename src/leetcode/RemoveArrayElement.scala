package leetcode

object RemoveArrayElement extends App {
	// for a list
	def remove(nums: List[Int], x: Int): Int = (nums filter (a => a != x)).length

	println(remove(List(1, 4, 2, 5, 3, 5, 6, 4, 3, 4, 5), 4))

	//for an array
	def remove(nums: Array[Int], x: Int): Int = {
		1
	}
}