package week3

object ClassHierarchies {

}

abstract class IntSet {
	def incl(x: Int): IntSet
	def contains_?(x: Int): Boolean
	def union(other: IntSet): IntSet
}

object Empty extends IntSet {
	def contains_?(x: Int): Boolean = false;

	def incl(x: Int): IntSet = new NonEmpty(x, Empty, Empty)

	def union(other: IntSet): IntSet = other

	override def toString = "."
}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
	def contains_?(x: Int): Boolean =
		if (elem == x) true
		else if (x < elem) left contains_? x
		else right contains_? x;

	def incl(x: Int): IntSet =
		if (elem == x) this
		else if (x < elem) left incl x
		else right incl x;

	def union(other: IntSet): IntSet =
		((left union right) union other) incl elem

	override def toString = "{" + left + elem + right + "}"
}