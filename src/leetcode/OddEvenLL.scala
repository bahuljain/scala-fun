package leetcode

import scala.annotation.tailrec

object OddEvenLL extends App {

	// not tail recursive and hence not very efficient

	def splitOddEven[T](list: List[T]): (List[T], List[T]) = list match {
		case Nil => (Nil, Nil)
		case List(x) => (List(x), Nil)
		case x :: y :: xs => {
			val (odd, even) = splitOddEven(xs)
			(x :: odd, y :: even)
		}
	}

	println(splitOddEven(List(1, 2, 3, 4, 5, 6, 7, 8, 9)))

	// more optimized and functional way to go about it :P

	def splitOddEven2[T](list: List[T]): List[T] = {
		val (odd, even) = list.zipWithIndex partition (_._2 % 2 == 0)
		odd.map(_._1) ++ even.map(_._1)
	}

	println(splitOddEven2(List(1, 2, 3, 4, 5, 6, 7, 8, 9)))

	assert(splitOddEven2(List()) == List())
	assert(splitOddEven2(List(1)) == List(1))
	assert(splitOddEven2(List(1, 2)) == List(1, 2))
	assert(splitOddEven2(List(1, 2, 3)) == List(1, 3, 2))
	assert(splitOddEven2(List(1, 2, 3, 4)) == List(1, 3, 2, 4))
}