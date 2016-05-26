package geek4geeks

import scala.collection.immutable.NumericRange

object AreaUnderCurve extends App {
	val coeffs: List[Double] = List(1, 2, 3, 4, 5)
	val pows: List[Double] = List(6, 7, 8, 9, 10)
	val (start, end) = (1.0, 4.0)
	val step = 0.001

	val xs: NumericRange[Double] = start to end by step

	println(xs.length)

	def f(x: Double) =
		coeffs zip pows map (e => e._1 * math.pow(x, e._2)) sum

	def area = xs map (f(_)) sum

	//	println(area)
}