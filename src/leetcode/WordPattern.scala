package leetcode

import scala.collection.breakOut

object WordPattern extends App {
	def wordPattern(pattern: String, str: String): Boolean = {
		val text = str.split(' ').toList
		if (text.length != pattern.length()) false
		else {
			val map: Map[Char, String] = (pattern zip text)(breakOut)
			val inverted_map: Map[String, Char] = (text zip pattern)(breakOut)
			if (pattern.toList.map(x => map(x)) == text
				&& text.map(x => inverted_map(x)) == pattern.toList) true
			else false
		}

	}

	println(wordPattern("abba", "dog cat cat dog"))
}
