package leetcode

import s99.{ Tree, Node, End }

object ListToTree extends App {
	def toTree[T](list: List[T]): Tree[T] = list match {
		case Nil => End
		case x :: Nil => Node(x)
		case _ => {
			val (left, right) = list.splitAt(list.length / 2)
			Node(right.head, toTree(left), toTree(right.tail))
		}
	}

	println(toTree(List(1, 2, 3, 4, 5, 6, 7, 8, 9)))
}