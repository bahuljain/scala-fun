package leetcode

object SimplifyPath extends App {
	def simplify(path: String): String = {
		val pos = path.lastIndexOf("/", path.length() - 2)
		path.substring(pos, path.length() - 1)
	}

	val path = "/home/"
	println(simplify(path))

	def reverseWords(s: String): String = {
		s.split(' ').reverse.mkString(" ")
	}

	val s = "the sky is blue"

	println(reverseWords(s))
}