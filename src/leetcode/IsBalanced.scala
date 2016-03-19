package leetcode

import s99.{ Tree, Node, End }

object IsBalanced extends App {
	def isBalanced[T](root: Tree[T]): Boolean = {
		def height(root: Tree[T]): Int = root match {
			case End => 0
			case Node(_, l, r) => {
				val hl = height(l); val hr = height(r)
				if (hl == -1 || hr == -1 || (hl - hr).abs > 1) -1
				else (hl + 1) max (hr + 1)
			}
		}
		height(root) != -1
	}

	val tree = Node(4, Node(2, Node(1), Node(3)), Node(6, Node(5), Node(7)))
	println(isBalanced(tree))
	println(isBalanced(Node(1, Node(1, Node(1), End), End)))
}