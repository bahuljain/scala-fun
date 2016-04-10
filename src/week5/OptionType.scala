package week5

object OptionType extends App {
	val x = Some(5)
	x.getOrElse(0)
	x.isDefined

	val y = Some(Some(6))
	println(y.flatten)

	val z = List(Some(6), Some(5), None)
	println(z.flatten)

	println(x filter { x => x > 6 })
}
