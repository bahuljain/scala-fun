package adventcode2016

object Day6 extends App {
	val filename = "src/adventcode2016/day6_input.txt"
	val lines = scala.io.Source.fromFile(filename).getLines.toList

	val frequencies = lines.map(_.toList).transpose.map(_.groupBy(identity).mapValues(_.size))
	val part1 = frequencies.map(_.maxBy(_._2)._1).mkString
	val part2 = frequencies.map(_.minBy(_._2)._1).mkString

	println(part1 + "\n" + part2)
}