package adventcode2016

object Day9 extends App {
	val filename = "src/adventcode2016/day9_input.txt"
	val format = scala.io.Source.fromFile(filename).mkString
	val marker = """\((\d+)x(\d+)\)""".r

	def decompress_V1(pos: Int, length: Int): Int = {
		format.indexOf('(', pos) match {
			case open if (open == -1) => length + (format.length - pos)
			case open => format.indexOf(')', open) match {
				case close if close == -1 => ???
				case close => format.substring(open, close + 1) match {
					case marker(chars, repeat) =>
						val c = chars.toInt
						val r = repeat.toInt
						decompress_V1(close + c + 1, length + (open - pos) + c * r)
				}
			}
		}
	}

	println(decompress_V1(0, 0))
}