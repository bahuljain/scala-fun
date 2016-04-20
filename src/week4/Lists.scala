package week4

import math.Ordering

object Lists extends App {
	val xs: List[Int] = List(5, 2, 7, 4, 3, 9, 1)
	println(xs.length)
	println(xs.takeRight(1)(0))
	println(xs.init)
	println(xs.last)

	def isort(l: List[Int]): List[Int] = {
		def insert(x: Int, l: List[Int]): List[Int] = l match {
			case y :: ys => if (x < y) x :: l else y :: insert(x, ys)
			case Nil => x :: Nil
		}

		l match {
			case Nil => Nil
			case y :: ys => insert(y, isort(ys))
		}
	}

	println(isort(xs))

	def removeAt(n: Int, xs: List[Int]): List[Int] = xs match {
		case Nil => throw new IndexOutOfBoundsException
		case y :: ys => if (n == 0) ys else y :: removeAt(n - 1, ys)
	}
	println(removeAt(2, xs))

	def msort[T](xs: List[T])(implicit ord: Ordering[T]): List[T] = {
		val mid = xs.length / 2

		if (mid == 0) xs
		else {
			def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
				case (xs, Nil) => xs
				case (Nil, ys) => ys
				case (x :: xtail, y :: ytail) =>
					if (ord.lt(x, y)) x :: merge(xtail, ys)
					else y :: merge(xs, ytail)
			}

			val (left, right): (List[T], List[T]) = xs.splitAt(mid)
			merge(msort(left), msort(right))
		}
	}

	println(msort(xs))
}