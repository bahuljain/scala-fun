package week2

import scala.annotation.tailrec

object RationalNumbers extends App {
	val x = new Rational(1, 3)
	val y = new Rational(5, 7)
	val z = new Rational(3, 2)

	println(x.add(y))
	println(x.neg)
	println(x.sub(y))
	println(x.sub(y).sub(z))
	println(x.add(x))
	println(x.less(y))
	println(x.max(y))

	//	val illegal = new Rational(1, 0)
}

class Rational(x: Int, y: Int) {
	require(y != 0, "Denominator must be non-zero")

	// constructor overloading
	def this(x: Int) = this(x, 1)

	@tailrec
	private def gcd(a: Int, b: Int): Int =
		if (b == 0) a else gcd(b, a % b);

	val num = x // gcd(x, y);
	val den = y // gcd(x, y);

	def less(that: Rational): Boolean =
		num * that.den < that.num * den

	def max(that: Rational): Rational =
		if (this.less(that)) that else this

	def add(that: Rational): Rational = new Rational(
		num * that.den + that.num * den,
		den * that.den)

	def neg: Rational = new Rational(-num, den)

	def sub(that: Rational): Rational = add(that.neg)

	override def toString = {
		val g = gcd(Math.abs(num), Math.abs(den))
		num / g + "/" + den / g
	}
}