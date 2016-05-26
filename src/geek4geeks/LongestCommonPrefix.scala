package geek4geeks

object LongestCommonPrefix extends App {
	def longestCommonPrefix(s1: String, s2: String) = {
		val pre = s1.zipWithIndex takeWhile (e => e._1 == s2(e._2))

		(pre map (_._1) mkString,
			s1 drop pre.length,
			s2 drop pre.length)
	}

	assert(longestCommonPrefix("abcdefpqr", "abcpqr") == ("abc", "defpqr", "pqr"), "1")
	assert(longestCommonPrefix("abcdefpqr", "pqr") == ("", "abcdefpqr", "pqr"), "2")
	assert(longestCommonPrefix("abcdefpqr", "abcdefpqr") == ("abcdefpqr", "", ""), "3")
}