package adventcode2016

object Day2 extends App {
	val filename = "src/adventcode2016/day2_input.txt"

	val keypad = Array(Array('0', '0', '1', '0', '0'),
		Array('0', '2', '3', '4', '0'), Array('5', '6', '7', '8', '9'),
		Array('0', 'A', 'B', 'C', '0'), Array('0', '0', 'D', '0', '0'))

	def move(dir: Char, cur: Int): Int = (dir: @unchecked) match {
		case 'U' => if (cur > 3) cur - 3 else cur
		case 'D' => if (cur < 7) cur + 3 else cur
		case 'L' => if (cur % 3 != 1) cur - 1 else cur
		case 'R' => if (cur % 3 != 0) cur + 1 else cur
	}

	def move(dir: Char, i: Int, j: Int) = (dir: @unchecked) match {
		case 'U' if (i != 0 && keypad(i - 1)(j) != 48) => (i - 1, j)
		case 'D' if (i != 4 && keypad(i + 1)(j) != 48) => (i + 1, j)
		case 'L' if (j != 0 && keypad(i)(j - 1) != 48) => (i, j - 1)
		case 'R' if (j != 4 && keypad(i)(j + 1) != 48) => (i, j + 1)
		case _ => (i, j)
	}

	def followGuide(guide: List[String], init: Int, init2: (Int, Int),
		code: String, code2: String): (String, String) = guide match {
		case Nil => (code.reverse, code2.reverse)
		case line :: rest => {
			val dst = line.foldLeft(init)((cur, dir) => move(dir, cur))
			val dst2 = line.foldLeft(init2) {
				(cur, dir) => move(dir, cur._1, cur._2)
			}
			followGuide(rest, dst, dst2, dst + code,
				keypad(dst2._1)(dst2._2) + code2)
		}
	}

	val lines = scala.io.Source.fromFile(filename).getLines().toList
	followGuide(lines, 5, (2, 0), "", "") match {
		case (code, code2) => println(code + "\n" + code2);
	}
}