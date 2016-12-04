package adventcode2016

object Day4 extends App {
	def compare(a: (Char, Int), b: (Char, Int)): Boolean =
		if (a._2 == b._2) a._1 < b._1 else a._2 > b._2

	def decrypt(ch: Char, shift: Int): Char =
		if (ch == '-') ' ' else ((ch - 'a' + shift) % 26 + 'a').toChar

	val filename = "src/adventcode2016/day4_input.txt"
	val lines = scala.io.Source.fromFile(filename).getLines.toList

	val real = lines.map(l => l.splitAt(l.lastIndexOf('-'))) map { room =>
		val tmp = room._2.tail.dropRight(1).split('[')
		(room._1, tmp(0).toInt, tmp(1))
	} filter { room =>
		room._1.filter(_ != '-')
			.groupBy(identity).mapValues(_.length).toList
			.sortWith(compare).take(5).map(_._1).mkString
			.equals(room._3)
	}

	val part1 = real map (_._2) sum
	val part2 = (real find {
		case (n, id, _) => n.map(decrypt(_, id)) == "northpole object storage"
	}).get._2

	println(part1 + "\n" + part2)
}