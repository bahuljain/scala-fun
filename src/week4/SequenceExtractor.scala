package week4

object Names {
	def unapplySeq(input: String): Option[Seq[String]] = {
		val names = input.split(" ")
		if (names.forall(_.isEmpty())) None
		else Some(names)
	}
}

object SequenceExtractor extends App {
	val names: String = "Bahul Zappos Stripe Nivea"

	names match {
		case Names(first, _*) => println(first)
		case _ => println("Nothing")
	}
}