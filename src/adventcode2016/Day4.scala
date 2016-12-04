package adventcode2016

object Day4 extends App {
	val filename = "src/adventcode2016/day4_input.txt"
	val lines = scala.io.Source.fromFile(filename).getLines.toList

	def compare(a: (Char, Int), b: (Char, Int)): Boolean =
		if (a._2 > b._2) true else if (a._2 < b._2) false else a._1 < b._1

	def magic_shift(ch: Char, shift: Int): Char =
		if (ch == '-') ' ' else (((ch - 'a') + shift) % 26 + 'a').toChar

	val valid_rooms = lines.map(line => line.splitAt(line.lastIndexOf('-'))) map {
		case (name, chksm) =>
			val tmp = chksm.tail.dropRight(1).split('[')
			(name, tmp(0).toInt, tmp(1))
	} filter { r =>
		r._1.filter(_ != '-').groupBy(identity).mapValues(_.length).toList
			.sortWith(compare).take(5).map(_._1).mkString.equals(r._3)
	}

	val part1 = valid_rooms.map(_._2).sum

	val part2 = valid_rooms find {
		case (name, id, _) => name.map(magic_shift(_, id)).equals("northpole object storage")
	} getOrElse ((Nil, -1, Nil))

	println(part1 + "\n" + part2._2)
}