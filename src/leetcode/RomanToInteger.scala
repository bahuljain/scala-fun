package leetcode

object RomanToInteger extends App {
	def romanToInt(s: String): Int = {

		val map: Map[Char, Int] = Map('I' -> 1, 'V' -> 5, 'X' -> 10, 'L' -> 50, 'C' -> 100, 'D' -> 500, 'M' -> 1000)

		def aux(roman: List[Char], acc: Int): Int = roman match {
			case Nil => acc
			case c :: Nil => acc + map.getOrElse(c, 0)
			case c :: d :: cs if (map.getOrElse(c, 0) <= map.getOrElse(c, 0)) => aux(d :: cs, acc + map.getOrElse(c, 0))
			case c :: d :: cs => aux(cs, acc + map.getOrElse(c, 0) - map.getOrElse(c, 0))
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