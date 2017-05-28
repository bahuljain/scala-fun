package adventcode2016
import scala.collection.breakOut
object Day13 extends App {
	def evenParity(n: Int) = Integer.bitCount(n) % 2 == 0
	def isOpen(x: Int, y: Int) = evenParity(x * x + 3 * x + 2 * x * y + y + y * y + 1358)

	/*	println((0 to 39) map {
		i => (0 to 31) map { j => (if (isOpen(j, i)) "." else "X") + (j, i)  } mkString (" ")
	} mkString ("\n"))*/

	/*	val map: Map[(Int, Int), Int] = (for {
		i <- 0 to 31
		j <- 0 to 39
		if (!isOpen(i, j))
	} yield ((i, j) -> Integer.MAX_VALUE))(breakOut)

	println(map.mkString("\n"))*/

	def walk(x: Int, y: Int, dir: Int, path: List[(Int, Int)]): Unit = {
		println(x, y)
		if (x == 31 && y == 39) println(path.mkString("\n"))
		else {
			if (dir != 0 && x > 0 && isOpen(x - 1, y)) walk(x - 1, y, 1, (x, y) :: path)
			if (dir != 1 && isOpen(x + 1, y)) walk(x + 1, y, 0, (x, y) :: path)
			if (dir != 2 && y > 0 && isOpen(x, y - 1)) walk(x, y - 1, 3, (x, y) :: path)
			if (dir != 3 && isOpen(x, y + 1)) walk(x, y + 1, 2, (x, y) :: path)
		}
	}

	walk(1, 1, 4, Nil)

}