package adventcode2016

import scala.annotation.tailrec

object Day12 extends App {
	val filename = "src/adventcode2016/day12_input.txt"
	val instructions = scala.io.Source.fromFile(filename).getLines.toList
	val cpy = """cpy (\d+|a|b|c|d) (a|b|c|d)""".r
	val inc = """inc (a|b|c|d)""".r
	val dec = """dec (a|b|c|d)""".r
	val jnz = """jnz (\d+|a|b|c|d) (-?\d+)""".r
	def incr(reg: String, registers: Map[String, Int]) = registers.updated(reg, registers.get(reg).get + 1)
	def decr(reg: String, registers: Map[String, Int]) = registers.updated(reg, registers.get(reg).get - 1)
	def copy(src: String, dest: String, registers: Map[String, Int]) = registers.get(src) match {
		case Some(value) => registers.updated(dest, value)
		case None => registers.updated(dest, src.toInt)
	}
	def jumpable(x: String, registers: Map[String, Int]): Boolean = registers.get(x) match {
		case Some(value) => value != 0
		case None => x.toInt != 0
	}

	@tailrec
	def solve(pos: Int, registers: Map[String, Int]): Map[String, Int] = {
		if (pos >= instructions.length) registers
		else {
			instructions(pos) match {
				case cpy(x, y) => solve(pos + 1, copy(x, y, registers))
				case inc(x) => solve(pos + 1, incr(x, registers))
				case dec(x) => solve(pos + 1, decr(x, registers))
				case jnz(x, y) =>
					if (jumpable(x, registers)) solve(pos + y.toInt, registers)
					else solve(pos + 1, registers)
			}
		}
	}
	println(solve(0, Map("a" -> 0, "b" -> 0, "c" -> 0, "d" -> 0)))
	println(solve(0, Map("a" -> 0, "b" -> 0, "c" -> 1, "d" -> 0)))
}