package week5

import scala.util.Try
import scala.io.Source

import java.net.URL

object TryErrorHandling extends App {
	def get(arr: Array[Int], pos: Int): Try[Int] = Try {
		arr(pos)
	}

	val arr = Array(1, 2, 3, 4, 5, 6, 7)

	val success = get(arr, 5)
	val fail = get(arr, -1)

	println(success)

	println(fail)

	println(success map { _ unary_- })
	println(fail map { _ unary_- })

	println(success flatMap { Try(_) })
	println(fail flatMap { Try(_) })

	println(success filter { _ < 3 })
	println(fail filter { _ < 3 })

	def throwable(x: Int) = {
		if (x < 0) throw new Exception("Yo")
		else x
	}

	try {
		throwable(-1)
	} catch {
		case _ => println("ok")
	}

	def parseURL(url: String): Try[URL] = Try(new URL(url))

	def getURLContent(url: String): Try[Iterator[String]] =
		for {
			url <- parseURL(url)
			connection <- Try(url.openConnection())
			is <- Try(connection.getInputStream)
			source = Source.fromInputStream(is)
		} yield source.getLines()

	val iterr = getURLContent("http://danielwestheide.com/blog/2012/12/26/the-neophytes-guide-to-scala-part-6-error-handling-with-try.html")

	iterr.get.foreach { println }
}
