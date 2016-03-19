package programming_in_scala.ch3

import scala.io.Source

object FileReading extends App {
	val lines = Source.fromFile("README.md").getLines().toList

	val lengths = lines map (_.length().toString())
	val maxL = lengths.map(_.length()).max

	for (entry <- lines zip lengths) {
		val pad = " " * (maxL - entry._2.length())
		println(pad + entry._2 + " : " + entry._1)
	}
}