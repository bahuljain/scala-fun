package leetcode

import s99.{ Tree, End, Node }

object SumRootToLeafNumbers extends App {
	def sum(root: Tree[Int]): Int = {
		def aux(root: Tree[Int], path: Int): Int = root match {
			case End => path
			case Node(e, l, End) => aux(l, path * 10 + e)
			case Node(e, End, r) => aux(r, path * 10 + e)
			case Node(e, l, r) => aux(l, path * 10 + e) + aux(r, path * 10 + e)
		}
		aux(root, 0)
	}

	val tree = Node(1, Node(2, Node(2), Node(5)), Node(3))

	println(sum(tree))
}