package week6

import scala.collection.immutable.NumericRange

object Collections extends App {
	val arr = Array(1, 2, 3, 4, 5, 6)
	for (i <- arr map (x => x * 2)) {
		println(i)
	}

	val range: NumericRange[Double] = -5.0 to 5.0 by 0.5
	println(range)
}