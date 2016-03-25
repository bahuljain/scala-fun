package s99

sealed abstract class Tree[+T]

case object End extends Tree[Nothing] {
	override def toString = "."
}

case class Node[T](value: T, left: Tree[T], right: Tree[T]) extends Tree[T] {
	override def toString = "(" + value.toString + " " + left.toString + " " + right.toString + ")"
}

object Node {
	def apply[T](value: T): Node[T] = Node(value, End, End)
}

case object Bogus extends Tree[Nothing] {
	override def toString = "BOGUS"
}