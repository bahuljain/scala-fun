package s99

//P55

object ConstructBalancedTree extends App {
	def construct(n: Int, e: String): List[Tree[String]] = {
		if (n <= 0) List(End)
		else if ((n - 1) % 2 == 0) {
			val subtrees = construct((n - 1) / 2, e)
			subtrees.flatMap(l => subtrees.flatMap(r => List(Node(e, l, r))))
		} else {
			val smallSubtree = construct((n - 1) / 2, e)
			val largeSubtree = construct((n - 1) / 2, e)
			smallSubtree.flatMap(l => largeSubtree.flatMap(r => List(Node(e, l, r), Node(e, r, l))))
		}
	}

	println(construct(4, "x").mkString("\n"))
}