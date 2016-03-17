package leetcode

object HappyNumber extends App {
	def isHappyNumber(n: Int): Boolean = {
		def sum(n: Int, acc: Int): Int = n match {
			case 0 => acc
			case _ => sum(n / 10, acc + (n % 10) * (n % 10))
		}
		val s = sum(n, 0)
		s match {
			case 0 => false
			case 1 => true
			case 4 => false
			case _ => isHappyNumber(s)
		}
	}

	assert(isHappyNumber(19) == true)
	println(isHappyNumber(18))
}