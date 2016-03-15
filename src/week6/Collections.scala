package week6

import scala.collection.immutable.NumericRange

object Collections extends App {
	val arr = Array(1, 2, 3, 4, 5, 6)
	for (i <- arr map (x => x * 2)) {
		println(i)
	}

	val nrange: NumericRange[Double] = -5.0 to 5.0 by 0.5
	println(nrange)

	val range = 1 to 10

	println((1 to 10).toList flatMap (x => (1 to 10).toList map (y => (x, y))))

	val vecX = Vector(1, 2, 3, 2, 1)
	val vecY = Vector(1, 0, 1, 0, 1)

	def scalarProd(vecX: Vector[Int], vecY: Vector[Int]): Int =
		(vecX zip vecY).map(xy => xy._1 * xy._2).sum

	println(scalarProd(vecX, vecY))

	def isPrime_?(x: Int): Boolean = (2 until x) forall (d => x % d != 0)

	assert(isPrime_?(29) == true)
}