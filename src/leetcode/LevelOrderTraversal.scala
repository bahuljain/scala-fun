package leetcode

import s99.{ Tree, Node, End, Bogus }
import scala.collection.immutable.Queue
import scala.annotation.tailrec

object LevelOrderTraversal extends App {

	def levelOrder[T](root: Tree[T]): List[List[T]] = {
		@tailrec
		def aux(queue: Queue[Tree[T]], acc: List[List[T]], level: List[T]): List[List[T]] = {
			queue.dequeueOption match {
				case None => acc.reverse
				case Some((head, tail)) => head match {
					case Bogus =>
						if (tail.isEmpty) acc.reverse
						else aux(tail.enqueue(Bogus), level.reverse :: acc, List())
					case End => aux(tail, acc, level)
					case Node(e, l, r) => aux(tail.enqueue(List(l, r)), acc, e :: level)
				}
			}
		}
		aux(Queue[Tree[T]](root, Bogus), Nil, Nil)
	}

	val tree = Node(3, Node(9), Node(20, Node(15), Node(7)))

	//	println(levelOrder(tree).mkString("\n"))

	//	val t: Tree[Int] = null
	//
	//	t match {
	//		case null => println("Null")
	//		case x => println(x)
	//	}

	val tList = List(End, Node(1), null)

	def print(x: List[Tree[Int]]): Unit = x match {
		case Nil => println("|")
		case null :: ys =>
			println("Null"); println(ys)
		case Node(e, _, _) :: ys =>
			println(e); print(ys)
		case End :: ys => println("End"); print(ys)
	}

	print(tList)
}