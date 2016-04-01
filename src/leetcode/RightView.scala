package leetcode

import s99.{ Node, End, Tree }
import scala.annotation.tailrec
import scala.collection.immutable.Queue

object RightView extends App {
	def rightView[T](root: Tree[T]): List[T] = {
		@tailrec
		def aux(queue: Queue[Tree[T]], acc: List[T], level: List[T]): List[T] = {
			queue.dequeueOption match {
				case None => acc.reverse
				case Some((head, tail)) => head match {
					case Bogus =>
						if (tail.isEmpty) acc.reverse
						else aux(tail.enqueue(Bogus), level.head :: acc, List())
					case End => aux(tail, acc, level)
					case Node(e, l, r) => aux(tail.enqueue(List(l, r)), acc, e :: level)
				}
			}
		}
		aux(Queue[Tree[T]](root, Bogus), Nil, Nil)
	}

	val tree = Node(1, Node(2, End, Node(5)), Node(3))

	println(rightView(tree))
}