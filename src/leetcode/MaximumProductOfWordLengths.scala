package leetcode

object MaximumProductOfWordLengths extends App {
	def maxProduct(words: List[String]): Int = {
		val res = for {
			word1 <- words;
			word2 <- words;
			if (word1 != word2);
			if (word1.toSet.intersect(word2.toSet).isEmpty)
		} yield word1.length() * word2.length()

		if (res.isEmpty) 0 else res.max
	}

	println(maxProduct(List("abcw", "baz", "foo", "bar", "xtfn", "abcdef")))
	println(maxProduct(List("a", "aa", "aaa", "aaaa")))

}