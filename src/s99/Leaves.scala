package s99

object CountLeaves extends App {
	//	P61
	def leaves[T](root: Tree[T]): Int = root match {
		case End => 0
		case Node(x, End, End) => 1
		case Node(x, left, right) => leaves(left) + leaves(right)
	}

	val tree = Node(1, Node(2, Node(4), Node(5)), Node(3, Node(6), Node(7)))
	println(leaves(tree))

	//	61A
	def collectLeaves[T](root: Tree[T]): List[T] = root match {
		case End => List()
		case Node(x, End, End) => List(x)
		case Node(x, left, right) => collectLeaves(left) ++ collectLeaves(right)
	}

	println(collectLeaves(tree))
}