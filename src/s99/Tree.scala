package s99

abstract class Tree[+T] {
}

case object End extends Tree[Nothing] {
	override def toString = "."
}

case class Node[T](value: T, left: Tree[T], right: Tree[T]) extends Tree[T] {
	override def toString = "(" + left.toString + " " + value.toString + " " + right.toString + ")"

	def compare(that: Node[T])(implicit ord: Ordering[T]): Int = ord.compare(this.value, that.value)

	def <(that: Node[T])(implicit ord: Ordering[T]): Boolean = (this compare that) < 0
	def >(that: Node[T])(implicit ord: Ordering[T]): Boolean = (this compare that) > 0
	def <=(that: Node[T])(implicit ord: Ordering[T]): Boolean = (this compare that) <= 0
	def >=(that: Node[T])(implicit ord: Ordering[T]): Boolean = (this compare that) >= 0
}

object Node {
	def apply[T](value: T): Node[T] = Node(value, End, End)
}