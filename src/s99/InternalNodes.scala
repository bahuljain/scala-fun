package s99

object InternalNodes extends App {
	def internal[T](root: Tree[T]): List[T] = root match {
		case End | Node(_, End, End) => List()
		case Node(x, left, right) => x :: (internal(left) ++ internal(right))
	}

	val tree = Node(1, Node(2, Node(4), Node(5)), Node(3, Node(6), Node(7)))
	println(internal(tree))
}