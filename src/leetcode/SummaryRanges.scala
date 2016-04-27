package leetcode

object SummaryRanges extends App {
	def summary(arr: List[Int]): List[String] = {
		def stringify(start: Int, end: Int) =
			if (start == end) s"$start"
			else s"$start -> $end"

		def aux(arr: List[Int], start: Int, prev: Int, acc: List[String]): List[String] = {
			arr match {
				case Nil => stringify(start, prev) :: acc
				case x :: xs if (x == prev + 1) => aux(xs, start, x, acc)
				case x :: xs => aux(xs, x, x, stringify(start, prev) :: acc)
			}
		}

		if (arr.isEmpty) Nil
		else aux(arr.tail, arr.head, arr.head, Nil) reverse
	}

	println(summary(List(1, 2, 3, 5, 6, 7, 9)))
	println(summary(List(1)))
	println(summary(List()))
	println(summary(List(1, 3)))
	println(summary(List(1, 2)))

}