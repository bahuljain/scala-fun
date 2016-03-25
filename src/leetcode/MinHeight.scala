package leetcode

import s99.{ Node, Tree, End }

object MinHeight extends App {
	def minHeight[T](root: Tree[T]): Int = root match {
		case End => 0
		case Node(e, End, End) => 1
		case Node(e, End, right) => 1 + minHeight(right)
		case Node(e, left, End) => 1 + minHeight(left)
		case Node(e, left, right) => 1 + (minHeight(left) min minHeight(right))
	}

	val tree = Node(5, Node(4), Node(8, Node(13), Node(4)))

	println(minHeight(tree))
}