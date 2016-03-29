package leetcode

import s99.{ Tree, Node, End }

object PreorderTraversal extends App {
	def preorder[T](root: Tree[T]) = {
		def aux(root: Tree[T], acc: List[T]): List[T] = root match {
			case End => acc
			case Node(e, l, r) => aux(r, aux(l, e :: acc))
		}
		aux(root, Nil).reverse
	}

	val tree = Node(4, Node(2, Node(1), Node(3)), Node(6, Node(5), Node(7)))

	println(preorder(tree))

}