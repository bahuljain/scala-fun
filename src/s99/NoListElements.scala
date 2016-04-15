package s99

object NoListElements extends App {
	def noelems[T](list: List[T]): Int = {
		list.length
	}

	def noelems1[T](list: List[T]): Int = {
		def aux(list: List[T], acc: Int): Int = list match {
			case Nil => acc
			case x :: xs => aux(xs, 1 + acc)
		}

		aux(list, 0)
	}

	println(noelems1(List(1, 2, 3, 4, 5, 6)))
}