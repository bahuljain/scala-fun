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

	def addBinary1(a: String, b: String): String = {
		def aux(a: List[Char], b: List[Char]): List[Char] = {
			val res = a.reverse.zipAll(b.reverse, '0', '0').foldLeft((List[Char](), '0')) { (acc, cur) =>
				val res = add(acc._2 :: cur._1 :: cur._2 :: Nil)
				(res._1 :: acc._1, res._2)
	      		}
	      		if (res._2 == '0') res._1 else res._2 :: res._1
	    	}

	    	def add(digits: List[Char]): (Char, Char) = digits.count(_ == '1') match {
	      		case 0 => ('0', '0')
	      		case 1 => ('1', '0')
		      	case 2 => ('0', '1')
		      	case 3 => ('1', '1')
		}

	   	aux(a.toList, b.toList).mkString		
	}
	
	println(addBinary("101", "11"))
	println(addBinary("101", "111"))
	println(addBinary("10101010", "1010101"))
}
