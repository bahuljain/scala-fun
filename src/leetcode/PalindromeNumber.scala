package leetcode

import scala.annotation.tailrec

object PalindromeNumber extends App {
	def isPalindrome_?(x: Int): Boolean = {
		@tailrec
		def rev(x: Int, y: Int): Int = x match {
			case 0 => y
			case _ => rev(x / 10, y * 10 + x % 10)
		}
		rev(x, 0) == x
	}

	println(isPalindrome_?(1234321))
}