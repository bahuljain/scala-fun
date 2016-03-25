package leetcode

import s99.{ Tree, Node, End }

object PathSum extends App {
	def pathSum(root: Tree[Int], target: Int): Boolean = {
		def aux(root: Tree[Int], sum: Int): Boolean = root match {
			case End => target == 0
			case Node(e, left, right) => (left, right) match {
				case (End, End) => (sum + e) == target
				case (End, _) => if (sum + e > target) false else aux(right, sum + e)
				case (_, End) => if (sum + e > target) false else aux(left, sum + e)
				case _ => if (sum + e > target) false else aux(left, sum + e) || aux(right, sum + e)
			}
		}
		aux(root, 0)
	}

	val tree = Node(5, Node(4, Node(11, Node(7), Node(2)), End), Node(8, Node(13), Node(4, End, Node(1))))

	assert(pathSum(tree, 22) == true)
	assert(pathSum(tree, 5) == false)
}