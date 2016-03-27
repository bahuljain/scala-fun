package leetcode

import s99.{ Tree, Node, End }

object BinaryTreePaths extends App {
	def paths[T](root: Tree[T]): String = {
		def aux(root: Tree[T]): List[List[T]] = root match {
			case End => Nil
			case Node(e, End, End) => List(List(e))
			case Node(e, left, End) => aux(left).map(e :: _)
			case Node(e, End, right) => aux(right).map(e :: _)
			case Node(e, left, right) => aux(left).map(e :: _) ++ aux(right).map(e :: _)
		}

		aux(root).map(_.mkString(" -> ")).mkString("\n")
	}
	val tree = Node(5,
		Node(4,
			Node(11,
				Node(7),
				Node(2)),
			End),
		Node(8,
			Node(13),
			Node(4,
				Node(0),
				Node(1))))

	println(paths(tree))
	/* Output
	5 -> 4 -> 11 -> 7
	5 -> 4 -> 11 -> 2
	5 -> 8 -> 13
	5 -> 8 -> 4 -> 0
	5 -> 8 -> 4 -> 1
	*/
}