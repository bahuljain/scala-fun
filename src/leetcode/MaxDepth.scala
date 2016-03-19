package leetcode

import s99.{ Tree, Node, End }

object MaxDepth extends App {
	def maxDepth[T](root: Tree[T]): Int = root match {
		case End => 0
		case Node(_, l, r) => (maxDepth(l) + 1) max (maxDepth(r) + 1)
	}

	val tree = Node(4, Node(2, Node(1), Node(3)), Node(6))
	println(maxDepth(tree))
	println(maxDepth(End))
	println(maxDepth(Node(1)))
	println(maxDepth(Node(1, Node(2, Node(3), End), End)))
}