package leetcode

object SortColors extends App {
	// count sort
	def sortColors(colors: List[Int]): List[Int] = {
		val map: Map[Int, Int] = colors.groupBy(identity).mapValues(_.length)

		(for {
			key <- map.keys.toList.sorted
		} yield List.fill(map.getOrElse(key, 0))(key)).flatten
	}

	println(sortColors(List(1, 2, 0, 2, 2, 2, 1, 0, 0)))
}