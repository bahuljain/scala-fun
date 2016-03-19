package leetcode

import java.math.BigInteger

object MultiplyStrings extends App {
	def multiply(num1: String, num2: String): String =
		(BigInt(num1) * BigInt(num2)).toString()

	println(multiply("23456564645", "446435123000400"))
}