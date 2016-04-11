package geek4geeks

import s99.{ Tree, Node, End }

object AddBST extends App {
	val tree = Node(4, Node(2, Node(1), Node(3)), Node(6, Node(5), Node(7)))

	def accumulate(root: Tree[Int]) = {
		def aux(root: Tree[Int], acc: Int): (Tree[Int], Int) = root match {
			case End => (End, acc)
			case Node(x, l, r) => {
				val (r1, acc1) = aux(r, acc)
				val (l1, acc2) = aux(l, acc1 + x)
				(Node(x + acc1, l1, r1), acc2)
			}
		}

		aux(root, 0)._1
	}

	println(accumulate(tree))
}