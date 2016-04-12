package leetcode

import scala.collection.immutable.TreeMap
import scala.collection.breakOut

object RemoveDuplicateLetters extends App {
	val string = "cbacdcbc"

	def removeDuplicates(string: String): String = {
		def aux(string: List[Char], acc: List[Char], map: Map[Char, Int]): String = string match {
			case Nil => acc.reverse.mkString
			case x :: Nil => (x :: acc).reverse.mkString
			case x :: xs if map.getOrElse(x, 0) == 1 => aux(xs, x :: acc, map - x)
			case x :: y :: xs if x > y =>
				aux(y :: xs, acc, map.updated(x, map.getOrElse(x, 0) - 1))
			case x :: y :: xs => {
				val with_x = aux((y :: xs).filter(_ != x), x :: acc, map - x)
				val without_x = aux(y :: xs, acc, map.updated(x, map.getOrElse(x, 0) - 1))

				if (with_x < without_x) with_x else without_x
			}
		}

		aux(string.toList, Nil, string.groupBy { identity }.mapValues { _.length })
	}

	println(removeDuplicates(string))

	println(removeDuplicates("bcabc"))
	println(removeDuplicates("bahuljainisthebestpersonintheworld"))

}