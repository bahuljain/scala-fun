package leetcode

object CompareVersion extends App {
	def compare(version1: String, version2: String): Int = {
		def aux(v1: List[Int], v2: List[Int]): Int = (v1, v2) match {
			case (Nil, Nil) => 0; case (xs, Nil) => 1; case (Nil, ys) => -1;
			case (x :: xs, y :: ys) =>
				if (x > y) 1
				else if (x < y) -1
				else aux(xs, ys)
		}
		val v1 = version1.split("\\.").map(_.toInt).toList.reverse.dropWhile(_ == 0).reverse
		val v2 = version2.split("\\.").map(_.toInt).toList.reverse.dropWhile(_ == 0).reverse
		aux(v1, v2)
	}

	println(compare("12.12.12.1", "12.12.12.1.0"))
}