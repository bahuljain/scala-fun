package programming_in_scala.ch1

object Exp extends App {
	def fact(x: Int): Int = x match {
		case 0.0 => 1
		case _ => x * fact(x - 1)
	}

	def exp(x: Float): Float = {
		(0 to 9).map(y => math.pow(x, y).toFloat / fact(y)).sum
	}

	println(exp(2))
}