package leetcode

object InsertInterval extends App {
	def insert(intervals: List[Interval], i: Interval): List[Interval] = intervals match {
		case Nil => List(i)
		case x :: xs =>
			if (i.end < x.start) i :: x :: xs
			else if (x.end < i.start) x :: insert(xs, i)
			else MergeIntervals.merge(Interval(i.start min x.start, i.end max x.end) :: xs)
	}

	val intervals = List(Interval(0, 2), Interval(5, 7), Interval(10, 19))

	println(insert(intervals, Interval(6, 10)))
}