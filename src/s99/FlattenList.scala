package s99

//p07

object FlattenList extends App {
	def flatten(l: List[Any]): List[Any] = l.flatMap {
		case innerList: List[Any] => flatten(innerList)
		case x: Any => List(x)
	}

	val x = List(List(0, 34), 2, List(30, List(15, List(21, 18))))

	println(flatten(x))

}