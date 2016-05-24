package greeter

object CSDSGrader extends App {
	val path = "/home/bahuljain/Downloads/CSDS-Submission/scores.csv"

	val data = io
		.Source
		.fromFile(path)
		.getLines
		.toList
		.map(_ split ",")
		.map {
			case Array(a, b, c, d, e, f, g, h, i, j, k, l) => (
				a, b, (c.toDouble + d.toDouble) / 2, e, f, g, (h.toDouble + k.toDouble) / 2, i, j, l,
				(c.toDouble + d.toDouble) / 4 +
				e.toDouble / 10 +
				f.toDouble / 10 +
				g.toDouble / 10 +
				(h.toDouble + k.toDouble) / 200 * 15 +
				i.toDouble / 2 +
				j.toDouble / 100 * 15 +
				l.toDouble / 16 * 30)
		}

	val sorted = data sortBy (_ _11) reverse

	val totalStudents = sorted.length.toDouble

	val (aPlus, rest) = sorted partition (_._11 > 97.5)
	val (a, axs) = rest splitAt ((0.6 * totalStudents) toInt)
	val (aMinus, bPlus) = axs partition (_._11 > 80)

	//	println(aPlus.mkString("\n") + "\n")
	//	println(a.mkString("\n") + "\n")
	//	println(aMinus.mkString("\n") + "\n")
	//	println(bPlus.mkString("\n") + "\n")

	//	val graded = sorted map {
	//		case (name, uni, score) => s"$name,$uni,$score"
	//	}

	val text = sorted mkString "\n"

	println(text split "\n" map (_ stripPrefix "(" stripSuffix ")") mkString "\n")
}