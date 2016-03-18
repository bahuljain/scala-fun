package week1

import scala.annotation.tailrec

object ParenthesisBalancing extends App {
	def isBalanced(str: List[Char]): Boolean = {
		@tailrec
		def aux(str: List[Char], cnt: Int): Boolean =
			if (cnt < 0) false
			else str match {
				case Nil => if (cnt == 0) true else false
				case (c :: cs) =>
					if (c == '(') aux(cs, cnt + 1)
					else if (c == ')') aux(cs, cnt - 1)
					else aux(cs, cnt)
			}
		aux(str, 0)
	}

	println(isBalanced("(())()()()()((())".toList))
}