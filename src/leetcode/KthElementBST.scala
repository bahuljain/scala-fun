package leetcode

import s99.{ Tree, Node, End }

object KthElementBST extends App {
	def kth[T](root: Tree[T], k: Int): Option[T] = {
		def inorder(root: Tree[T]): List[T] = root match {
			case End => Nil
			case Node(e, l, r) => inorder(r) ++ (e :: inorder(l))
		}

		val inorderList = inorder(root).reverse
		if (k > inorderList.length) None
		else Some(inorderList.splitAt(k - 1)._2.head)
	}

	val tree = Node(4, Node(2, Node(1), Node(3)), Node(6, Node(5), Node(7)))

	println(kth(tree, 1))
}