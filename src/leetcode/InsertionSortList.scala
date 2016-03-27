package leetcode

object InsertionSortList extends App {
	def isort(l: List[Int]): List[Int] = {
		def insert(x: Int, l: List[Int]): List[Int] = l match {
			case y :: ys => if (x < y) x :: l else y :: insert(x, ys)
			case Nil => x :: Nil
		}

		l match {
			case Nil => Nil
			case y :: ys => insert(y, isort(ys))
		}
	}

	println(isort(List(2, 5, 8, 3, 6, 1)))
}