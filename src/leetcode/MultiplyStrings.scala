package leetcode

import java.math.BigInteger

object MultiplyStrings extends App {
	def multiply(num1: String, num2: String): String =
		(new BigInteger(num1)).multiply(new BigInteger(num2)).toString()

	println(multiply("23456", "1234"))
}