package leetcode

import scala.annotation.tailrec

object RemoveDuplicatesFromSortedList extends App {
	def findUniques[T](list: List[T]): List[T] = {
		@tailrec
		def aux(list: List[T], acc: List[T]): List[T] = list match {
			case Nil => acc
			case x :: xs => {
				val tmp = xs.dropWhile(_ == x)
				aux(tmp, if (tmp.length == xs.length) x :: acc else acc)
			}
		}
		aux(list, Nil).reverse
	}

	def findNonDuplicates(list: List[Int]): List[Int] =
		(list.groupBy(identity).mapValues(_.length).filter(_._2 == 1).map(_._1)).toList.sorted

	println(findNonDuplicates(List(1, 2, 2, 3, 4, 4, 4, 4, 5, 5, 5, 6, 7, 8, 8, 9, 10, 10)))
	println(findUniques(List(1, 2, 2, 3, 4, 4, 4, 4, 5, 5, 5, 6, 7, 8, 8, 9, 10, 10)))

	def deleteDuplicates[T](list: List[T]): List[T] = {
		@tailrec
		def aux(list: List[T], prev: T, acc: List[T]): List[T] = list match {
			case Nil => acc
			case x :: xs => if (x == prev) aux(xs, x, acc) else aux(xs, x, x :: acc)
		}

		list match {
			case Nil => Nil
			case x :: xs => aux(xs, x, List(x)).reverse
		}
	}

	def deleteDuplicates_++[T](list: List[T])(implicit ord: Ordering[T]): List[T] = list.distinct

	assert(deleteDuplicates(List(1, 1, 2, 2, 2, 3, 3, 4, 4, 4, 4, 4, 5)) == List(1, 2, 3, 4, 5))
	assert(deleteDuplicates_++(List(1, 1, 2, 2, 2, 3, 3, 4, 4, 4, 4, 4, 5)) == List(1, 2, 3, 4, 5))

}