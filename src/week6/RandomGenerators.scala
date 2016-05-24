package week6

trait Generator[+T] {
	self => // alias for this

	def generate: T

	def map[S](f: T => S): Generator[S] = new Generator[S] {
		def generate = f(self.generate)
	}

	def flatMap[S](f: T => Generator[S]): Generator[S] = new Generator[S] {
		def generate = f(self.generate).generate
	}
}

object RandomGenerators extends App {
	def intGen = new Generator[Int] {
		def generate = {
			val rand = new java.util.Random
			rand.nextInt()
		}
	}

	def boolGen: Generator[Boolean] =
		for (x <- intGen) yield x > 0
	// integer map (_ > 0)

	def pairGen[T, U](t: Generator[T], u: Generator[U]): Generator[(T, U)] = for {
		x <- t
		y <- u
	} yield (x, y)

	def single[T](x: T): Generator[T] = new Generator[T] {
		def generate = x
	}

	def choose(low: Int, high: Int): Generator[Int] =
		for (x <- intGen) yield low + x % (high - low)

	def oneOf[T](xs: T*): Generator[T] =
		for (idx <- choose(0, xs.length)) yield xs(idx)

	def listGen: Generator[List[Int]] = {
		def emptyList: Generator[List[Int]] = single(Nil)

		def nonEmptyList: Generator[List[Int]] = for {
			head <- intGen
			tail <- nonEmptyList
		} yield head :: tail

		for {
			isEmpty <- boolGen
			xs <- if (isEmpty) emptyList else nonEmptyList
		} yield xs
	}

	def treeGen: Generator[Tree] = {
		def leafGen: Generator[Leaf] =
			for (num <- intGen) yield Leaf(num)

		def innerGen: Generator[Inner] = for {
			left <- treeGen
			right <- treeGen
		} yield Inner(left, right)

		for {
			isLeaf <- boolGen
			node <- if (isLeaf) leafGen else innerGen
		} yield node
	}

	def test[T](g: Generator[T], numTimes: Int = 100)(test: T => Boolean): Unit = {
		for (i <- 1 to numTimes) {
			val value = g.generate
			assert(test(value), "Test failed for " + value)
		}
		println("Total test cases passed: " + numTimes)
	}

	test(choose(-10, 5))(num => num >= -10 && num < 5)

	//	for (i <- 0 until 100) {
	//		println(choose(0, 5) generate)
	//	}
}

trait Tree
case class Inner(left: Tree, right: Tree) extends Tree
case class Leaf(x: Int) extends Tree
