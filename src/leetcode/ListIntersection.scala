package leetcode

import scala.annotation.tailrec

object ListIntersection extends App {
	val commonTail = List(7, 8, 9, 10)
	val x = 1 :: 2 :: 3 :: commonTail
	val y = 5 :: 6 :: commonTail

	def intersection[T](x: List[T], y: List[T]): T = {
		val diff = (x.length - y.length)

		@tailrec
		def aux(xl: List[T], yl: List[T]): T = (xl, yl) match {
			case (Nil, Nil) | (Nil, _) | (_, Nil) => throw new NoSuchElementException
			case (x :: xs, y :: ys) => if (x == y) x else aux(xs, ys)
		}

		if (diff > 0) aux(x.drop(diff), y)
		else aux(x, y.drop(diff.abs))
	}

	println(intersection(commonTail, y))

}