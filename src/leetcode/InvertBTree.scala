package leetcode

import s99.{ Tree, Node, End }

object InvertBTree extends App {
	def invert[T](root: Tree[T]): Tree[T] = root match {
		case End => End
		case Node(e, l, r) => Node(e, invert(r), invert(l))
	}

	val tree = Node(4, Node(2, Node(1), Node(3)), Node(6, Node(5), Node(7)))
	println(invert(tree))
}