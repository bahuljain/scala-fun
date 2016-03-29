package week3

abstract class Identity {
	// add abstract methods with full signature.
	def self(x: Int): Int
}

class Same extends Identity {
	def self(x: Int) = { println("same"); x; }
}

trait Double extends Same {
	// super remains unknown until the class is made.
	abstract override def self(x: Int) = { println("double"); x + super.self(x) }
}

trait Square extends Same {
	// super remains unknown until the class is made.
	abstract override def self(x: Int) = { println("square"); x * super.self(x); }
}

object TraitMadness extends App {
	val x1 = new Same with Double with Square
	println(x1.self(5))

	val x2 = new Same with Square with Double
	println(x2.self(5))
}