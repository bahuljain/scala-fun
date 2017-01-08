package adventcode2016

case class Display(private val display: List[List[Boolean]]) {
	private val rectP = """rect (\d+)x(\d+)""".r
	private val rotRowP = """rotate row y=(\d+) by (\d+)""".r
	private val rotColP = """rotate column x=(\d+) by (\d+)""".r

	private def rotate(arr: List[Boolean])(by: Int) =
		arr.takeRight(by) ++ arr.dropRight(by)

	private def rotateRow(row: Int)(by: Int): Display = Display(
		display.zipWithIndex map {
			case (r, idx) => if (row == idx) rotate(r)(by) else r
		})

	private def rotateCol(col: Int)(by: Int): Display = Display(
		display.transpose.zipWithIndex map {
			case (c, idx) => if (col == idx) rotate(c)(by) else c
		} transpose)

	private def rect(row: Int, col: Int): Display = Display(
		display.zipWithIndex map {
			case (r, idx) => if (idx < row) r.zipWithIndex map {
				case (c, idx) => if (idx < col) true else c
			}
			else r
		})

	override def toString = display.map(_.map(if (_) '#' else '-') mkString (" ")) mkString ("\n")
	def countLit: Int = this.display.flatten.count(identity)

	def applyInstr(instr: String): Display = (instr: @unchecked) match {
		case rectP(col, row) => this.rect(row.toInt, col.toInt)
		case rotRowP(row, by) => this.rotateRow(row.toInt)(by.toInt)
		case rotColP(col, by) => this.rotateCol(col.toInt)(by.toInt)
	}
}

object Day8 extends App {
	val filename = "src/adventcode2016/day8_input.txt"
	val lines = scala.io.Source.fromFile(filename).getLines.toList
	val display = Display(List.fill(6)(List.fill(50)(false)))

	val code = lines.foldLeft(display) {
		case (disp, instr) => disp.applyInstr(instr)
	}

	println(code.countLit)
	println(code.toString)
}