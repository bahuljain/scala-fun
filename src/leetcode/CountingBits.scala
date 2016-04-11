package leetcode

object CountingBits extends App {
	def countingBits(num: Int) = {
		(for {
			n <- 0 to num
		} yield (Integer.bitCount(n))).toArray
	}

	var startTime = System.nanoTime()
	val x = countingBits(10000)
	println(s"Time Elapsed: ${System.nanoTime() - startTime}")

	def countingBits1(num: Int) = {
		val start = List(0, 1)

		def aux(xs: List[Int], acc: List[Int]): List[Int] = xs match {
			case Nil => acc.reverse
			case y :: ys => aux(ys, (y + 1) :: acc)
		}

		def aux1(start: List[Int]): List[Int] =
			if (start.length > num) start.take(num + 1)
			else aux1(aux(start, start.reverse))

		aux1(start).toArray
	}

	startTime = System.nanoTime()
	val y = countingBits1(10000)
	println(s"Time Elapsed: ${System.nanoTime() - startTime}")
}