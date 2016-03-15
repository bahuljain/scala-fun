package week5

object ListFunctions extends App {
	val list: List[Int] = List(-4, -3, -2, -1, 0, 1, 2, 3, 4)
	println(list map (x => x * x))

	println(list filter (x => x < 0))
	println(list filterNot (x => x < 0))
	println(list partition (x => x < 0))

	println(list takeWhile (x => x <= -2))
	println(list dropWhile (x => x <= -2))
	println(list span (x => x <= -2))

	def pack[T](list: List[T]): List[List[T]] = list match {
		case Nil => Nil
		case x :: xs => {
			val (fst, snd) = list span (a => a == x)
			fst :: pack(snd)
		}
	}

	def rle[T](list: List[T]): List[(T, Int)] =
		pack(list) map (x => (x.head, x.length))

	val data = List(1, 1, 1, 1, 2, 3, 4, 4, 4, 4, 3, 3, 2, 2, 2, 8, 8, 8, 8)
	println(pack(data))
	println(rle(data))
}