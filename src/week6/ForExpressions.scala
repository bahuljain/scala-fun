package week6

object ForExpressions {
	/*
	 * case class Person(name: String, age: Int)
	 *
	 * for ( p <- persons if p.age > 20 ) yield p.name
	 */

	def primeCombinations(n: Int, m: Int) = {
		def isPrime_?(x: Int): Boolean = (2 until x) forall (d => x % d != 0)
		for {
			i <- 1 until n
			j <- 1 until m
			if (isPrime_?(i + j))
		} yield (i, j)
	}

	def scalarProduct(vec1: List[Double], vec2: List[Double]): Double = {
		(for {
			i <- (vec1 zip vec2)
		} yield i._1 * i._2).sum
	}

}