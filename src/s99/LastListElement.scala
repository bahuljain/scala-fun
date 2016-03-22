package s99

// P01

object LastListElement extends App {
	def last[T](list: List[T]): T = {
		list.last
	}
	println(last(List(1, 2, 3, 4, 5, 5, 6)))

	def last1[T](list: List[T]): Option[T] = list match {
		case Nil => None
		case x :: Nil => Some(x)
		case x :: xs => last1(xs)
	}

	println(last1(List(1, 2, 3, 4, 5, 5, 6)))
}