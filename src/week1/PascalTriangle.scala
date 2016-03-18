package week1

object PascalTriangle extends App {

	def pascal(c: Int, r: Int): Int = {
		def add(l1: List[Int], l2: List[Int]): List[Int] =
			(l1 zip l2) map (x => x._1 + x._2)

		def getRow(row: List[Int], target: Int): List[Int] = (target) match {
			case 0 => row
			case _ => getRow(add(0 :: row, row ++ List(0)), target - 1)
		}

		if (c > r) throw new IndexOutOfBoundsException
		else getRow(List(1), r)(c)
	}

	println(pascal(0, 2))
	println(pascal(1, 2))
	println(pascal(1, 3))
	println(pascal(4, 8))
}