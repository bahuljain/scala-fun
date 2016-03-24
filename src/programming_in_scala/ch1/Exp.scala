package programming_in_scala.ch1

object Exp extends App {
	def fact(x: Int): Float = x match {
		case 0.0 => 1.toFloat
		case _ => x.toFloat * fact(x - 1)
	}

	def pow(x: Float, e: Int): Float = e match {
		case 0 => 1
		case _ => x * pow(x, e - 1)
	}

	def exp(x: Float): Float = {
		(0 to 9).map(y => pow(x, y) / fact(y)).sum
	}

	println(exp(2))
}