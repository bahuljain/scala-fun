package s99

// P01

object LastListElement extends App {
	def last[T](list: List[T]): T = {
		list.last
	}
	println(last(List(1, 2, 3, 4, 5, 5, 6)))
}