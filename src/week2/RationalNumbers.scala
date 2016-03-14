package week2

import scala.annotation.tailrec

object RationalNumbers extends App {
	val x = new Rational(1, 3)
	val y = new Rational(5, 7)
	val z = new Rational(3, 2)
	//	val m = x * y

	println(x + y)
	println(-x)
	println(x - y)
	println(x - y - z)
	println(x + x)
	println(x < y)
	println(x max y)

	//	println("Precedence check: " + m)

	//	val illegal = new Rational(1, 0)
}

class Rational(x: Int, y: Int) {
	require(y != 0, "Denominator must be non-zero")

	// constructor overloading
	def this(x: Int) = this(x, 1)

	@tailrec
	private def gcd(a: Int, b: Int): Int =
		if (b == 0) a else gcd(b, a % b);

	val num = x / gcd(x, y);
	val den = y / gcd(x, y);

	def <(that: Rational): Boolean =
		num * that.den < that.num * den

	def max(that: Rational): Rational =
		if (this < that) that else this

	def +(that: Rational): Rational = new Rational(
		num * that.den + that.num * den,
		den * that.den)

	def unary_- : Rational = new Rational(-num, den)

	def -(that: Rational): Rational = this + -that

	// this isn't working :(
	def *(that: Rational): Rational = new Rational(num * that.num, den * that.num)

	override def toString = {
		//		val g = gcd(Math.abs(num), Math.abs(den))
		num + "/" + den
	}
}