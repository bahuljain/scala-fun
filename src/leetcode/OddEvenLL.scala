package leetcode

import scala.annotation.tailrec

object OddEvenLL extends App {
	def splitOddEven[T](list: List[T]): (List[T], List[T]) = list match {
		case Nil => (Nil, Nil)
		case List(x) => (List(x), Nil)
		case x :: y :: xs => {
			val (odd, even) = splitOddEven(xs)
			(x :: odd, y :: even)
		}
	}

	println(splitOddEven(List(1, 2, 3, 4, 5, 6, 7, 8, 9)))
}