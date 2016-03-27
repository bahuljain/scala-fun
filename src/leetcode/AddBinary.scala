package leetcode

object AddBinary extends App {
	def addBinary(bs1: String, bs2: String): String = {
		def aux(bs1: List[Char], bs2: List[Char], c: Char, acc: List[Char]): List[Char] = (bs1, bs2) match {
			case (Nil, Nil) => if (c == '1') '1' :: acc else acc
			case (Nil, b :: bs) => {
				val res = add('0', b, c)
				aux(Nil, bs, res._2, res._1 :: acc)
			}
			case (a :: as, Nil) => {
				val res = add(a, '0', c)
				aux(as, Nil, res._2, res._1 :: acc)
			}
			case (a :: as, b :: bs) => {
				val res = add(a, b, c)
				aux(as, bs, res._2, res._1 :: acc)
			}
		}

		def add(c1: Char, c2: Char, c3: Char): (Char, Char) = (c1, c2, c3) match {
			case ('0', '0', '0') => ('0', '0')
			case ('0', '0', '1') | ('0', '1', '0') | ('1', '0', '0') => ('1', '0')
			case ('0', '1', '1') | ('1', '1', '0') | ('1', '0', '1') => ('0', '1')
			case ('1', '1', '1') => ('1', '1')
		}

		aux(bs1.toList.reverse, bs2.toList.reverse, '0', Nil).mkString("")
	}

	println(addBinary("101", "11"))
	println(addBinary("101", "111"))
	println(addBinary("10101010", "1010101"))
}