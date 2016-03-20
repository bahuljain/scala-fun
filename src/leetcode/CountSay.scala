package leetcode

object CountSay extends App {
	def countSay(n: Int) = {
		def pack(str: String, cur: Char, cnt: Int): List[(Char, Int)] = str match {
			case "" => List((cur, cnt))
			case _ =>
				if (cur == str.head) pack(str.tail, cur, cnt + 1)
				else (cur, cnt) :: pack(str.tail, str.head, 1)
		}

		def loop(n: Int, str: String): String = n match {
			case 1 => str
			case _ =>
				val p = pack(str, str.head, 0).map(x => x._2.toString() + x._1).mkString("")
				loop(n - 1, p)
		}

		loop(n, "1")
	}

	println((for (i <- 1 to 10) yield countSay(i)).mkString("\n"))

}