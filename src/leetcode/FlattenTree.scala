package leetcode

import s99.{ Tree, Node, End }

object FlattenTree extends App {

	def addRightMost[T](root: Tree[T], node: Tree[T]): Tree[T] = root match {
		case End => node
		case Node(e, l, r) => Node(e, l, addRightMost(r, node))
	}

	def flatten[T](root: Tree[T]): Tree[T] = root match {
		case End => End
		case Node(e, l, r) => Node(e, End, flatten(addRightMost(l, r)))
	}

	println(flatten(Node(1, Node(2, Node(3), Node(4)), Node(5, End, Node(6)))))
	println(flatten(Node(9, Node(8, Node(7, Node(6, Node(5), End), End), End), End)))
}