package leetcode

case class Interval(val start: Int, val end: Int) extends Ordered[Interval] {
	//	import scala.math.Ordered.orderingToOrdered
	def this() = this(0, 0)
	def compare(that: Interval): Int = this.start compare that.start
}