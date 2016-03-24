package programming_in_scala.ch3

object InRead extends App {
	for {
		ln <- io.Source.stdin.getLines.zipWithIndex
		if (ln._2 % 2 == 0)
	} println(ln._1)
}