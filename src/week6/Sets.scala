package week6

import scala.annotation.tailrec

object Sets extends App {
	def nqueens(n: Int): Set[List[Int]] = {
		def isSafe(col: Int, queens: List[Int]): Boolean = {
			val row = queens.length
			@tailrec
			def loop(queens: List[Int], r: Int): Boolean = queens match {
				case Nil => true
				case c :: cs =>
					if (row - r == Math.abs(col - c) || col == c) false
					else loop(cs, r - 1)
			}
			loop(queens, row - 1)
		}

		def placeQueen(k: Int): Set[List[Int]] = {
			if (k == 0) Set(List())
			else
				for {
					queens <- placeQueen(k - 1)
					col <- 0 until n
					if isSafe(col, queens)
				} yield col :: queens
		}
		placeQueen(n)
	}

	def show(queens: List[Int]) = {
		val lines =
			for (col <- queens.reverse)
				yield Vector.fill(queens.length)("* ").updated(col, "Q ").mkString
		lines.mkString("\n") + "\n"
	}

	println(nqueens(8).take(3).map(show).mkString(" \n"))
}
