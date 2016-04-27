package leetcode

object IsomorphicStrings extends App {
	def isomorphic(s1: String, s2: String): Boolean = {
		if (s1.length() != s2.length()) return false

		def aux(map: Map[Char, Char], rev: Map[Char, Char], lp: List[(Char, Char)]): Boolean =
			lp match {
				case Nil => true
				case (c1, c2) :: lps =>
					if (map.getOrElse(c1, c2) == c2 && rev.getOrElse(c2, c1) == c1)
						aux(map + (c1 -> c2), rev + (c2 -> c1), lps)
					else false
			}
		aux(Map(), Map(), (s1 zip s2).toList)
	}

	println(isomorphic("aab", "xyy"))
	println(isomorphic("aay", "bbz"))
	println(isomorphic("bahul", "japan"))
	println(isomorphic("", "a"))
	println(isomorphic("rubbish", "rubbers"))
}
