package leetcode

import scala.annotation.tailrec

object CountSmallerNumbersAfterSelf extends App {
	def count(list: List[Int]): List[Int] = {
		@tailrec
		def aux(list: List[Int], acc: List[Int]): List[Int] = list match {
			case Nil => acc
			case x :: xs => aux(xs, xs.filter(x > _).length :: acc)
		}
		aux(list, Nil).reverse
	}	

	println(count(List(9, 8, 7, 6, 5, 4, 3, 2, 1)))
	println(count(List(5, 2, 6, 1)))
}