package week2

object AnonymousFunctions extends App {

	//currying functions here!!
	def sum(f: Int => Int)(a: Int, b: Int): Int = {
		def loop(a: Int, acc: Int): Int = {
			if (a > b) acc
			else loop(a + 1, acc + f(a))
		}
		loop(a, 0)
	}

	val sumF: (Int, Int) => Int = (x: Int, y: Int) => x + y;

	assert(1 == 2, "Wrong!")

	println(sum(x => x * x)(2, 5))

}