package leetcode

object RomanToInteger extends App {
	def romanToInt(s: String): Int = {

		def get(c: Char): Int = c match {
			case 'I' => 1
			case 'V' => 5
			case 'X' => 10
			case 'L' => 50
			case 'C' => 100
			case 'D' => 500
			case 'M' => 1000
			case _ => 0
		}

		def aux(roman: List[Char], acc: Int): Int = roman match {
			case Nil => acc
			case c :: Nil => acc + get(c)
			case c :: d :: cs if (get(c) <= get(d)) => aux(d :: cs, acc + get(c))
			case c :: d :: cs => aux(cs, acc + get(c) - get(d))
		}

		aux(s.toUpperCase().toList.reverse, 0)
	}

	assert(romanToInt("xix") == 19)
	assert(romanToInt("iii") == 3)
	assert(romanToInt("iv") == 4)
	assert(romanToInt("viii") == 8)
	assert(romanToInt("xiv") == 14)
	assert(romanToInt("ccxl") == 240)
}