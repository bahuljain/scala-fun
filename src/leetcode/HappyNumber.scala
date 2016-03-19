package leetcode

import scala.annotation.tailrec

object HappyNumber extends App {
	def isHappyNumber(n: Int): Boolean = {
		@tailrec
		def sum(n: Int, acc: Int): Int = n match {
			case 0 => acc
			case _ => sum(n / 10, acc + (n % 10) * (n % 10))
		}
		sum(n, 0) match {
			case 0 => false
			case 1 => true
			case 4 => false
			case s => isHappyNumber(s)
		}
	}

	assert(isHappyNumber(19) == true)
	println(isHappyNumber(18))
}