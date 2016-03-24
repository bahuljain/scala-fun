package s99

object DecodeRLE extends App {
	def replicate[T](list: List[T], n: Int) = {
		list.map(x => List.fill(n)(x)).flatten
	}

	println(replicate(List(1, 2, 3), 3))

	//	P12
	def decode[T](list: List[(Int, T)]): List[T] = {
		list.map(x => List.fill(x._1)(x._2)).flatten
	}

	println(decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))))
}