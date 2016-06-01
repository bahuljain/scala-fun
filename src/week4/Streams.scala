package week4

object Streams extends App {
	println(0 #:: (1 to 1000).toStream)

	def from(n: Int): Stream[Int] = n #:: from(n + 1);

	val nats = from(0)
	val mul4 = nats map (_ * 4)

	println(nats)
	println(nats, mul4 take 100 toList)

	def sieve(n: Stream[Int]): Stream[Int] =
		n.head #:: sieve(n filter (_ % n.head != 0))

	println(sieve(from(2)) take 100 toList)
}