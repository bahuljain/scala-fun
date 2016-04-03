package geek4geeks

object Quicksort extends App {
	def quicksort[T](list: List[T])(implicit ord: Ordering[T]): List[T] = list match {
		case Nil => Nil
		case _ =>
			val pivot = list.head
			val (left, right) = list.tail.partition(ord.lt(_, pivot))
			quicksort(left) ++ (pivot :: quicksort(right))
	}

	println(quicksort(List(4, 2, 6, 8, 7, 6, 6, 7, 5)))

}