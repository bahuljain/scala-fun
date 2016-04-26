package geek4geeks

object ExcelColumns extends App {
	/*
	 * 1 A
	 * 2 B
	 * 26 Z
	 * 27 AA
	 */

	var type_variable = 1;

	def excelColumn = {
		var tmp = type_variable
		var new_type = ""
		while (tmp != 0) {
			val code: Int = if (tmp % 26 == 0) 'Z' else (tmp % 26) + 64
			tmp = if (code == 90) (tmp - 1) / 26 else tmp / 26
			new_type = code.toChar + new_type
		}

		type_variable += 1
		new_type
	}

	var start = System.nanoTime
	for (i <- (0 to 10)) {
		excelColumn
	}
	println("Method 1", System.nanoTime - start)

	var typ = ""
	def get_new_type = {
		def next(str: String): String = {
			def aux(str: List[Char], acc: List[Char], carry: Boolean): String = str match {
				case Nil => (if (carry) 'A' :: acc else acc) mkString
				case x :: xs if (!carry) => aux(xs, x :: acc, false)
				case 'Z' :: xs if (carry) => aux(xs, 'A' :: acc, true)
				case x :: xs => aux(xs, (x + 1).toChar :: acc, false)
			}
			aux(str.toList.reverse, Nil, true)
		}
		typ = next(typ)
		typ
	}

	start = System nanoTime

	for (i <- (0 to 10)) {
		get_new_type
	}
	println("Method 2", System.nanoTime - start)

	val alphabets = 'A' to 'Z'
	var n = 0
	var iterator = Iterator[IndexedSeq[Char]]()
	def get_new_typ = {
		def next: IndexedSeq[Char] =
			if (iterator hasNext) iterator next
			else {
				n += 1
				iterator = alphabets combinations n
				next
			}
		next mkString
	}

	start = System nanoTime

	for (i <- (0 to 10)) {
		get_new_typ
	}

	println("Method 3", System.nanoTime - start)

}