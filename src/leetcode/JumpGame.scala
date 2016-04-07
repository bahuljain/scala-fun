package leetcode

import scala.annotation.tailrec

object JumpGame extends App {
	def canJump(nums: List[Int]): Boolean = {
		@tailrec
		def aux(nums: List[Int], max: Int): Boolean = {
			if (max < 0) false
			else nums match {
				case Nil | List(_) => true
				case x :: xs if (x > max) => aux(xs, x)
				case x :: xs => aux(xs, max - 1)
			}
		}
		aux(nums, nums.head)
	}

	println(canJump(List(3, 2, 1, 0, 4)))
}