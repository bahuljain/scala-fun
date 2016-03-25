package s99

//P17

object Split extends App {
	def split[T](list: List[T], n: Int): (List[T], List[T]) =
		list.splitAt(n)

	println(split(List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k), 4))

}