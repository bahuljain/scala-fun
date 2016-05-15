package greeter

import scala.collection.breakOut

object Stats {
	def avg(data: List[Double]) = data.sum / data.length

	def stdev(data: List[Double]): Double = {
		if (data.length < 2)
			return Double.NaN
		// average
		val mean: Double = avg(data)

		val sum = data.foldLeft(0.0)((sum, tail) => {
			val dif = tail - mean
			sum + dif * dif
		})

		Math.sqrt(sum / (data.length - 1))
	}
}

object ERGrader extends App {

	val path = "/home/bahuljain/Desktop/ER_Instabase.csv"

	def getScores(path: String): List[String] =
		io.Source.fromFile(path).getLines().toList

	def processing(lines: List[String]) /*: List[(String, Double)] */ = lines.tail
		.map { _.split(',') }
		.filterNot { _.length == 1 }
		.map { case e => (e(0), e(1).trim.toDouble) }

	val scores = processing(getScores(path))

	println(s"Mean Score: ${Stats.avg(scores.map(_._2))}")

	println(s"Standard Deviation: ${Stats.stdev(scores.map(_._2))}")

	//	val sortedScores = scores.sorted

	val scores1 = scores.filter(_._2 > 90)

	//	scores1 foreach println

	//	val min = scores1.minBy(_._2)._2
	//	val max = scores1.maxBy(_._2)._2

	val scaledScores = scores1
		.map { case e => (e._1, (e._2 - 90) / (10) * 20 + 10) }
		.map { case e => s"${e._1},${e._2}" }

	scaledScores foreach println

}