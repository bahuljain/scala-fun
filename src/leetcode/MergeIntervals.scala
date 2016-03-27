package leetcode

object MergeIntervals extends App {
	def merge(list: List[Interval]): List[Interval] = {
		def aux(l: List[Interval], acc: List[Interval]): List[Interval] = l match {
			case Nil => acc
			case List(x) => x :: acc
			case x :: y :: xs =>
				if (x.start <= y.start && x.end >= y.start)
					aux(Interval(x.start, x.end max y.end) :: xs, acc)
				else aux(y :: xs, x :: acc)
		}
		aux(list.sorted, Nil).reverse
	}

	val ilist: List[Interval] = List(Interval(10, 19), Interval(5, 7), Interval(0, 1), Interval(12, 14), Interval(1, 2))
	println(merge(ilist))

}