package adventcode2016

class Item
case class Generator(elem: String) extends Item
case class Microchip(compatible_elem: String) extends Item

object Day11 extends App {
	val filename = "src/adventcode2016/day11_input.txt"
	val instructions = scala.io.Source.fromFile(filename).getLines.toList
	val floor_instructions = """The (\w+) floor contains (.*).""".r
	val generator = """a (\w+) generator""".r
	val microchip = """a (\w+)-compatible microchip""".r

	def floor_contents(instr: String): List[Item] = instr match {
		case "nothing relevant" => Nil
		case _ => instr.split(""" , and """).toList map {
			case generator(elem) => Generator(elem)
			case microchip(elem) => Microchip(elem)
		}
	}

	/*"The third floor contains nothing relevant." match {
			case floor_instructions(a, b) => println(a, b)
		}*/

}