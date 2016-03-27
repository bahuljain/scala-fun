package week1

import scala.annotation.tailrec

object TailRecursion extends App {
	println("Tail Recursion Examples");

	@tailrec
	def gcd(a: Int, b: Int): Int =
		// tail-recursive function call :)
		if (b == 0) a else gcd(b, a % b);

	println(gcd(14, 21));

	def factorial(n: Int): Int =
		// this line here is not tail-recursive, hence consumes stack space
		if (n == 0) 1 else n * factorial(n - 1);

	def factorialTailRec(n: Int): Int = {
		@tailrec
		def aux(n: Int, acc: Int): Int =
			if (n == 0) acc else aux(n - 1, acc * n);

		aux(n, 1);
	}

	println(factorial(10))
	println(factorialTailRec(10))

	val x: Any = 10
}