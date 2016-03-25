package s99

//P19

object Rotate extends App {
	def rotate[T](n: Int, list: List[T]): List[T] = {
		val shifts = n % list.length
		val steps = if (n < 0) list.length + shifts else shifts
		val splits = list.splitAt(steps)
		splits._2 ::: splits._1
	}

	println(rotate(5, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
}