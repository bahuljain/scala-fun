package leetcode

import scala.annotation.tailrec

object PlusOne extends App {
	def addLists(xl: List[Int], yl: List[Int]): List[Int] = {
		@tailrec
		def add(xl: List[Int], yl: List[Int], c: Int, acc: List[Int]): List[Int] = (xl, yl) match {
			case (Nil, Nil) => if (c == 1) 1 :: acc else acc
			case (Nil, y :: ys) => add(Nil, ys, (y + c) / 10, (y + c) % 10 :: acc)
			case (x :: xs, Nil) => add(xs, Nil, (x + c) / 10, (x + c) % 10 :: acc)
			case (x :: xs, y :: ys) => add(xs, ys, (x + y + c) / 10, (x + y + c) % 10 :: acc)
		}
		add(xl.reverse, yl.reverse, 0, Nil)
	}

	println(addLists(List(9, 0, 1), List(9, 9)))
	println(addLists(List(2, 7), List(3, 2, 8)))

	def plusOne(arr: List[Int]): List[Int] = addLists(arr, List(1))

	println(plusOne(List(9, 9, 9)))
}