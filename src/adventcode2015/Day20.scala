package adventcode2015

object Day20 extends App {
	val input = 29000000 / 10;

	def gcd(a: Long, b: Long): Long = if (b == 0) a.abs else gcd(b, a % b)
	def lcm(a: Long, b: Long): Long = a * b / gcd(a, b)

	/*def factorSum(n: Long): Long = (1 to n).filter(n % _ == 0).sum
	def factorSum2(n: Long): Long = (1 to math.sqrt(n).toLong).filter(n % _ == 0).map(x => if (x * x == n) x else x + n / x).sum*/

	def part1(factorSum: Long, i: Long, l: Long): Long = {
		println(factorSum + l, i, l);
		if (factorSum + l >= input) l
		else part1(factorSum + i, i + 1, lcm(i, l))
	}

	println(part1(0, 1, 1))
}