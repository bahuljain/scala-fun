package s99

object DFS extends App {
	def inorder[T](root: Tree[T]): List[T] = root match {
		case End => Nil
		case Node(e, left, right) => inorder(left) ++ List(e) ++ inorder(right)
	}

	val tree = Node(4, Node(2, Node(1), Node(3)), Node(6, Node(5), Node(7)))
	println((tree))
}