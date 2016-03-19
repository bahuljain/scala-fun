package programming_in_scala

object BigInts extends App {
	def factorial(x: Int): BigInt =
		if (x == 0) 1 else x * factorial(x - 1)

	println(factorial(30))

	def multiply(x: String, y: String): String =
		(BigInt(x) * BigInt(y)).toString()

	println(multiply("21312431534634", "31593854074147347"))

}