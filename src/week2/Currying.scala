package week2

object Currying extends App {
	def product(f: Int => Int)(a: Int, b: Int): Int = {
		if (a > b) 1
		else f(a) * product(f)(a + 1, b)
	}

	println(product(x => x)(2, 5))

	def factorial(n: Int): Int = product(x => x)(1, n)
	println(factorial(5))

	def mapReduce(base: Int, reduce: (Int, Int) => Int, map: Int => Int)(a: Int, b: Int): Int = {
		if (a > b) base
		else reduce(map(a), mapReduce(base, reduce, map)(a + 1, b))
	}

	println(mapReduce(1, (x, y) => x * y, x => x * x)(3, 4))
}