package geek4geeks

object RemoveN extends App {

	// Remove n characters from the string to obtain the lexicographically greatest string

	def remove_n(str: String, n: Int): String = {
		require(n <= str.length())

		def aux(str: List[Char], n: Int, store: List[Char]): String =
			if (n == 0) (store.reverse ++ str).mkString
			else (str: @unchecked) match {
				case c :: Nil if (store.isEmpty) => ""
				case c :: Nil => aux(store.reverse, n - 1, Nil)
				case c :: d :: cs if (c >= d) => aux(d :: cs, n, c :: store)
				case c :: d :: cs => aux(store.reverse ++ (d :: cs), n - 1, Nil)
			}

		aux(str.toList, n, Nil)
	}

	assert(remove_n("band", 1) == "bnd")
	assert(remove_n("band", 2) == "nd")
	assert(remove_n("bandhan", 3) == "nhan")
	assert(remove_n("japan", 3) == "pn")
	assert(remove_n("", 0) == "")
	assert(remove_n("rubbish", 7) == "")

}