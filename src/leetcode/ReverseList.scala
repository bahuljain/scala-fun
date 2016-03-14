package leetcode

import scala.annotation.tailrec

object ReverseList {
	def reverse[T](xs: List[T]): List[T] = {
		@tailrec
		def rev(xs: List[T], acc: List[T]): List[T] = xs match {
			case Nil => acc
			case x :: xs1 => rev(xs1, x :: acc)
		}
		rev(xs, List())
	}

	println(reverse(List(1, 2, 3, 4, 5, 6, 7, 8, 9)))
}