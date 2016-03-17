package week6

object Maps extends App {
	val m = Map(1 -> 2, 2 -> 3, 3 -> 4)

	println(m(2))

	val map = Map('2' -> "ABC", '3' -> "DEF", '4' -> "GHI", '5' -> "JKL",
		'6' -> "MNO", '7' -> "PQRS", '8' -> "TUV", '9' -> "WXYZ")

	val rev = (for (key <- map.keys; chars <- map(key)) yield (chars -> key)).toMap

	println(rev)

	sealed trait btree[+A]
}