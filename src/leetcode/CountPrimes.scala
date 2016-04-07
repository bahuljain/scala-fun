package leetcode

import scala.annotation.tailrec

object CountPrimes extends App {

	// count prime numbers till n
	def countPrimes(n: Int): Int = {
		@tailrec
		def aux(count: Int, list: List[Int]): Int = {
			if (list.head <= math.sqrt(n))
				aux(count + 1, list.filterNot(_ % list.head == 0))
			else count + list.length
		}
		aux(0, (2 to n).toList)
	}

	println(countPrimes(3))
	println(countPrimes(5))
	println(countPrimes(10))
	println(countPrimes(100))
}