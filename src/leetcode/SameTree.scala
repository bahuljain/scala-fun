package leetcode

import s99.{ Tree, Node, End }

object SameTree extends App {
	def isSame[T](root1: Tree[T], root2: Tree[T]): Boolean = (root1, root2) match {
		case (End, End) => true
		case (_, End) | (End, _) => false
		case (Node(_, l1, r1), Node(_, l2, r2)) => isSame(l1, l2) && isSame(r1, r2)
	}

	val tree = Node(4, Node(2, Node(1), Node(3)), Node(6, Node(5), Node(7)))
	println(isSame(tree, tree))
}