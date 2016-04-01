package leetcode

object Anagram extends App {
	def groupAnagrams(strings: List[String]): List[List[String]] = {
		strings.groupBy(_.sorted).values.toList
	}

	println(groupAnagrams(List("eat", "tea", "tan", "ate", "nat", "bat", "ant", "tab")))
}