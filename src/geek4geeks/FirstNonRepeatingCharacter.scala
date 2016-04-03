package geek4geeks

object FirstNonRepeatingCharacter extends App {
	def countWay(s: String) = {
		val countMap = s.toList.groupBy(identity).mapValues(_.length)
		val index = s.indexWhere(x => countMap.getOrElse(x, -1) == 1)
		s.charAt(index)
	}

	println(countWay("geeksforgeeks"))
}