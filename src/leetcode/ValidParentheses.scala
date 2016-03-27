package leetcode

object ValidParentheses extends App {
	def isValid(str: String): Boolean = {
		val map: Map[Char, Char] = Map(')' -> '(', '}' -> '{', ']' -> '[')
		def aux(stack: List[Char], str: String): Boolean = str.headOption match {
			case None => stack.isEmpty
			case Some(c) => c match {
				case '(' | '{' | '[' => aux(str.head :: stack, str.tail)
				case ')' | '}' | ']' =>
					if (stack.head == map(c)) aux(stack.tail, str.tail)
					else false
			}
		}
		aux(Nil, str)
	}

	assert(isValid("()(){()}{()[][()]}") == true)
	assert(isValid("{{{{{") == false)
}