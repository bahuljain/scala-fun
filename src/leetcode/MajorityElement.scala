package leetcode

import scala.annotation.tailrec

object MajorityElement extends App {
	def majorityElement(nums: List[Int]): Option[Int] = {
		@tailrec
		def aux(nums: List[Int], maj: Int, acc: Int): Int = nums match {
			case Nil => maj
			case x :: xs =>
				if (x == maj) aux(xs, maj, acc + 1)
				else if (acc > 0) aux(xs, maj, acc - 1)
				else aux(xs, x, 1)
		}
		val maj = aux(nums.tail, nums.head, 1)
		val count = nums.filter(y => y == maj).length

		if (count > nums.length / 2) Some(maj)
		else None
	}

	println(majorityElement(List(1, 2, 3, 4, 5, 6, 7, 7)))
	println(majorityElement(List(7, 7, 7, 4, 5, 6, 7, 7)))
}