package s99

// P02

object Penultimate {
	def penultimate[T](list: List[T]): Option[T] = list match {
		case Nil => None
		case x :: Nil => None
		case x :: y :: xs => Some(x)
		case x :: xs => penultimate(xs)
	}
}