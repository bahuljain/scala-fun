package geek4geeks

object StringSwapper extends App {
	def swapper(string: String): String =
		string.grouped(2).map(_.reverse).mkString

	println(swapper("hello!"))
}