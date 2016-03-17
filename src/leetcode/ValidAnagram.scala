package leetcode

object ValidAnagram extends App {
	def isAnagram(s: String, t: String): Boolean = {

		def aux(map: Map[Char, Int], indices: List[Int]): Boolean = indices match {
			case Nil =>
				if (map.forall(e => e._2 == 0)) true else false
			case i :: is => {
				val tmp: Map[Char, Int] = map + (s(i) -> (map(s(i)) + 1))
				aux(tmp.+(t(i) -> (tmp(t(i)) - 1)), is)
			}
		}

		aux(Map() withDefaultValue 0, ((0 until s.length()).toList))
	}

	println(isAnagram("bahul", "luhab"))

	def isAnagram_+(s: String, t: String): Boolean = {

		def aux(indices: Range) = {
			val map: Map[Char, Int] = Map() withDefaultValue 0
			indices.foldLeft(map) { (acc, i) =>
				val tmp: Map[Char, Int] = acc + (s(i) -> (acc(s(i)) + 1))
				tmp.+(t(i) -> (tmp(t(i)) - 1))
			}
		}

		val res = aux(0 until s.length())
		if (res.forall(e => e._2 == 0)) true else false
	}

	println(isAnagram("baahhul", "luehbah"))

}