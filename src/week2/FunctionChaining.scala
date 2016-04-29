package week2

object FunctionChaining extends App {
	val square: Int => Int = x => x * x
	val neg: Int => Int = -_
	val double: Int => Int = 2 * _
	val half: Int => Int = _ / 2
	val inc: Int => Int = _ + 1
	val complement: Boolean => Boolean = !_
	val even: Int => Boolean = _ % 2 == 0

	val pipeline = Function.chain(Seq(
		square,
		neg,
		inc,
		neg,
		double))

	println((pipeline andThen even andThen complement)(2))
}