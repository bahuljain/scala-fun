package leetcode

object InterleavingStrings extends App {
	def isInterleaved(s1: String, s2: String, s3: String): Boolean = {
		def aux(s1: List[Char], s2: List[Char], s3: List[Char]): Boolean = (s1, s2, s3) match {
			case (Nil, Nil, Nil) => true
			case (a :: as, b :: bs, c :: cs) =>
				if (c == a && c == b) aux(as, s2, cs) || aux(s1, bs, cs)
				else if (c == a) aux(as, s2, cs)
				else if (c == b) aux(s1, bs, cs)
				else false
			case (Nil, b :: bs, c :: cs) if (b == c) => aux(Nil, bs, cs)
			case (a :: as, Nil, c :: cs) if (a == c) => aux(as, Nil, cs)
			case _ => false
		}
		if (s1.length() + s2.length() != s3.length()) false
		else aux(s1.toList, s2.toList, s3.toList)
	}

	val s1 = "aabcc"
	val s2 = "dbbca"

	val s3 = "aadbbcbcac"
	val s4 = "aadbbbaccc"

	println(isInterleaved(s1, s2, s4))
}