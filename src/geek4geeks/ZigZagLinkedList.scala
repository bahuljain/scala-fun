package geek4geeks

import scala.annotation.tailrec

object ZigZagLinkedList extends App {
	def zigzag[T](list: List[T])(implicit ord: Ordering[T]): List[T] = {
		@tailrec
		def aux(list: List[T], c: Boolean, acc: List[T]): List[T] = list match {
			case Nil => acc
			case x :: Nil => x :: acc
			case x :: y :: xs => c match {
				case false if (ord.lt(x, y)) => aux(y :: xs, true, x :: acc)
				case true if (ord.gt(x, y)) => aux(y :: xs, false, x :: acc)
				case c => aux(x :: xs, !c, y :: acc)
			}
		}

		aux(list, false, Nil).reverse
	}

	println(zigzag(List(1, 2, 3, 0, 1, 2, 3)))

	assert(zigzag(List(1, 2, 3, 4)) == List(1, 3, 2, 4))
	assert(zigzag(List(1, 2, 3, 0, 1, 2, 3)) == List(1, 3, 0, 2, 1, 3, 2))
	assert(zigzag(List(11, 15, 20, 5, 10)) == List(11, 20, 5, 15, 10))
	assert(zigzag(List(11)) == List(11))
	assert(zigzag(List(11, 10)) == List(10, 11))
	assert(zigzag(List(4, 3, 7, 8, 6, 2, 1)) == List(3, 7, 4, 8, 2, 6, 1))

}