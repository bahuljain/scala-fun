package s99

//P56

object SymmetricTree extends App {
	def isSameTree[T](rootA: Tree[T], rootB: Tree[T]): Boolean = (rootA, rootB) match {
		case (End, End) => true
		case (End, Node(_, _, _)) => false
		case (Node(_, _, _), End) => false
		case (Node(x, xl, xr), Node(y, yl, yr)) =>
			x == y && isSameTree(xl, yl) && isSameTree(xr, yr)
	}

	def invertTree[T](root: Tree[T]): Tree[T] = root match {
		case End => End
		case Node(x, xl, xr) => Node(x, invertTree(xr), invertTree(xl))
	}

	def isSymmetric[T](root: Tree[T]): Boolean =
		isSameTree(root, invertTree(root))

	println(isSymmetric(Node(1, Node(2, End, Node(3)), Node(2, Node(3), End))))
	println(isSymmetric(Node(1, Node(2, Node(4), Node(3)), Node(2, Node(3), End))))
}