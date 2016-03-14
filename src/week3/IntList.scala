package week3

trait List[T] {
	def isEmpty: Boolean
	def head: T
	def tail: List[T]
}

class Nil[T] extends List[T] {
	def isEmpty: Boolean = true
	def head: T = throw new NoSuchElementException("Nil")
	def tail: List[T] = throw new NoSuchElementException("Nil")
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
	def isEmpty = false
	//	def head: T = head
	//	def tail: List[T] = tail
}

object nth extends App {
	def nth[T](n: Int, xs: List[T]): T = {
		if (xs.isEmpty) throw new IndexOutOfBoundsException
		else if (n == 0) xs.head
		else nth(n - 1, xs.tail)
	}

	val list = new Cons(1, new Cons(2, new Cons(3, new Nil)))

	println(nth(2, list))
	println(nth(3, list))
}

object List {
	def apply[T](x1: T, x2: T): List[T] = new Cons(x1, new Cons(x2, new Nil))
	def apply[T]: List[T] = new Nil
}