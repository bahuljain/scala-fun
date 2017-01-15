package adventcode2016

object Day9 extends App {
	val format = scala.io.Source.fromFile("src/adventcode2016/day9_input.txt").mkString
	val r_marker = """\((\d+)x(\d+)\)""".r

	def decompress_V1(pos: Int, len: Int): Int = format.indexOf('(', pos) match {
		case open if (open == -1) => len + (format.length - pos)
		case open => format.indexOf(')', open) match {
			case close if close == -1 => ???
			case close => format.substring(open, close + 1) match {
				case r_marker(chars, repeat) =>
					val c = chars.toInt
					val r = repeat.toInt
					decompress_V1(close + c + 1, len + (open - pos) + c * r)
			}
		}
	}

	def decompress_V2(pos: Int, len: Long, fmt: String): Long =
		fmt.indexOf('(', pos) match {
			case open if open == -1 => len + (fmt.length - pos)
			case open => fmt.indexOf(')', open) match {
				case close if close == -1 => ???
				case close => fmt.substring(open, close + 1) match {
					case r_marker(chars, repeat) =>
						val c = chars.toInt
						val r = repeat.toInt
						r * decompress_V2(0, 0, fmt.substring(close + 1, close + c + 1)) +
							decompress_V2(close + c + 1, len + (open - pos), fmt)
				}
			}
		}
	println(decompress_V1(0, 0), decompress_V2(0, 0, format))
}