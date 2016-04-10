package week5

object PartialFunctions extends App {
	val wordFrequencies = ("habitual", 6) :: ("and", 56) :: ("consuetudinary", 2) ::
		("additionally", 27) :: ("homely", 5) :: ("society", 13) :: Nil

	println(wordFrequencies.collect {
		case (w, f) if f > 3 => w
	})
}