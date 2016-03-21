package s99

//P55

object ConstructBalancedTree extends App {
	def construct(n: Int, e: String): Tree[String] = {
		if (n == 0) End
		else if ((n - 1) % 2 == 0) Node(e, construct((n - 1) / 2, e), construct((n - 1) / 2, e))
		else Node(e, construct((n - 1) / 2 + 1, e), construct((n - 1) / 2, e))
	}

	println(construct(4, "x"))
}