package greeter

object CSDSGrader extends App {
	val path = "/home/bahuljain/Documents/Columbia/CSDS/finalscores.csv"

	val data = io
		.Source
		.fromFile(path)
		.getLines()
		.toList
		.map(_.split(","))
		.map { case e => (e(0), e(1), e(2).trim.toDouble) }
		.sortBy(_._3)
		.reverse

	val totalStudents = data.length.toDouble

	val (aPlus, rest) = data.splitAt(8)
	val (a, axs) = rest.splitAt((0.6 * totalStudents).toInt)
	val (aMinus, bPlus) = axs partition { _._3 > 80 }

	//	val APlus = data filter { _._3 >= 97 }

	//	val A = data filter { case e => e._3 < 97 && e._3 >= 85 }

	//	val AMinus = data filter { case e => e._3 < 85 && e._3 >= 75 }

	//	val BPlus = data filter { _._3 < 75 }

	println(aPlus.mkString("\n"))
	println()
	println(a.mkString("\n"))
	println()
	println(aMinus.mkString("\n"))
	println()
	println(bPlus.mkString("\n"))

	/*println(aPlus.length / totalStudents)
	println(a.length / totalStudents)
	println(aMinus.length / totalStudents)
	println(bPlus.length / totalStudents)*/

}