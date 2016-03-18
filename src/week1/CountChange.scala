package week1

object CountChange extends App {
	//	Still contains some errors 1+1+2 is not considered same as 2+1+1 or 1+2+1
	def countChange(money: Int, coins: List[Int]): Int = {
		var store = Array.fill[Int](money + 1)(0)
		store.update(0, 1)

		def get(i: Int): Int = if (i < 0) 0 else store(i)

		for (i <- (1 to money)) {
			store.update(i, (coins map (coin => get(i - coin))).sum)
		}
		store(money)
	}

	println(countChange(4, List(1, 2)))
}