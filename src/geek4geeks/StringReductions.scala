package geek4geeks

import scala.annotation.tailrec

object StringReductions extends App {
	def reduce(s: String) = {
		s.distinct
	}

	//	this can be optimized to a tail recursive function
	def reduce1(s: String): String = {
		if (s.isEmpty) s
		else s.head + reduce1(s.tail filter { _ != s.head })
	}

	def reduce2(s: String): String = {
		@tailrec
		def aux(s: String, acc: String): String = {
			if (s.isEmpty) acc.reverse
			else aux(s.tail filter { _ != s.head }, s.head + acc)
		}
		aux(s, "")
	}

	println(reduce2("accabb"))
	println(reduce2("pprrqq"))
}