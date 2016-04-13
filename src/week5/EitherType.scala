package week5

object EitherType extends App {
	def get(arr: Array[Int], pos: Int): Either[String, Int] = {
		if (pos < 0 || pos >= arr.length) Left("Array Index Out of Bounds.")
		else Right(arr(pos))
	}

	val arr = Array(1, 2, 3, 4, 5, 6)

	println(get(arr, 4))
	println(get(arr, -1))

}