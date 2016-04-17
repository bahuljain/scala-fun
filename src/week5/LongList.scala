package week5

import scala.collection.mutable.ListBuffer

object LongList extends App {
	val x = List.range(0, 100000)
	//	println(x.mkString("\n"))

	def inc(list: List[Int]) = {
		def aux(list: List[Int], acc: List[Int]): List[Int] = list match {
			case Nil => acc.reverse
			case x :: xs => aux(xs, x + 1 :: acc)
		}

		// Fails: Stack Overflow (Not a good technique for JVM)
		def aux1(list: List[Int]): List[Int] = list match {
			case Nil => Nil
			case x :: xs => x + 1 :: aux1(xs)
		}

		def aux2(list: List[Int]): List[Int] = list.map { _ + 1 }

		// Behind the scenes this is happening. Most optimized for JVM
		def listBuf(list: List[Int]) = {
			val buf = new ListBuffer[Int]
			for (x <- list) buf += (x + 1)
			buf.toList
		}

		aux2(list)
	}
	println(inc(x).mkString("\n"))
}