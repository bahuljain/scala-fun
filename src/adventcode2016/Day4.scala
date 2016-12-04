package adventcode2016

object Day4 extends App {
	def decrypt(ch: Char, shift: Int): Char =
		if (ch == '-') ' ' else ((ch - 'a' + shift) % 26 + 'a').toChar

	val filename = "src/adventcode2016/day4_input.txt"
	val lines = scala.io.Source.fromFile(filename).getLines.toList
	val pattern = """([a-z-]+)(\d+)\[(\w+)\]""".r

	val real_rooms = lines.map(_.toLowerCase) map {
		case pattern(name, id, chksm) => (name.dropRight(1), id.toInt, chksm)
	} filter { room =>
		room._1.filter(_ != '-')
			.groupBy(identity).mapValues(_.length).toList
			.sortBy(_._1).sortBy(-_._2).map(_._1).mkString
			.startsWith(room._3)
	}

	val part1 = real_rooms map (_._2) sum
	val part2 = (real_rooms find {
		case (n, id, _) => n.map(decrypt(_, id)).startsWith("north")
	}).get._2

	println(part1 + "\n" + part2)
}