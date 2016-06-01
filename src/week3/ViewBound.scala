package week3

object ViewBound extends App {
	def max[T](elements: List[T])(implicit ord: T => Ordered[T]): T =
		elements match {
			case List() => throw new IllegalArgumentException("Empty List!")
			case List(x) => x
			case x :: xs =>
				val maxRest = max(xs) // ord has been implicitly supplied here
				if (x > maxRest) x // ord(x) is implicit here
				else maxRest
		}

	// Since the name ord has never been used in the above function we can
	// simply eliminate it using View Bounds

	def maxView[T <% Ordered[T]](elements: List[T]): T =
		elements match {
			case List() => throw new IllegalArgumentException("Empty List!")
			case List(x) => x
			case x :: xs =>
				val maxRest = maxView(xs)
				if (x > maxRest) x
				else maxRest
		}
}