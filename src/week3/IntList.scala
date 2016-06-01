package week3

trait MyList[T] {
	def isEmpty: Boolean
	def head: T
	def tail: MyList[T]
}

class Nil[T] extends MyList[T] {
	def isEmpty: Boolean = true
	def head: T = throw new NoSuchElementException("Nil")
	def tail: MyList[T] = throw new NoSuchElementException("Nil")
}

class Cons[T](val head: T, val tail: MyList[T]) extends MyList[T] {
	def isEmpty = false
	//	def head: T = head
	//	def tail: MyList[T] = tail
}

object nth extends App {
	def nth[T](n: Int, xs: MyList[T]): T = {
		if (xs.isEmpty) throw new IndexOutOfBoundsException
		else if (n == 0) xs.head
		else nth(n - 1, xs.tail)
	}

	val MyList = new Cons(1, new Cons(2, new Cons(3, new Nil)))

	println(nth(2, MyList))
	println(nth(3, MyList))
}

object MyList {
	def apply[T](x1: T, x2: T): MyList[T] = new Cons(x1, new Cons(x2, new Nil))
	def apply[T]: MyList[T] = new Nil
}