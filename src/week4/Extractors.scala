package week4

object Twice {
	def apply(x: Int): Int = x * 2
	def unapply(z: Int): Option[Int] = if (z % 2 == 0) Some(z / 2) else None
}

object TwiceTest extends App {
	// apply function is called here
	val x = Twice(21)

	x match {
		// unapply function is called here
		case Twice(n) => Console.println(n)
	}
}

// Extractor for case with multiple values
class User(val name: String, val age: Int)

object User {
	def apply(name: String, age: Int): User = new User(name, age)
	def unapply(user: User): Option[(String, Int)] = Some(user.name, user.age)
}

object UserTest extends App {
	val person: User = User("bahul", 23)

	val User(name, age) = person
	val n User a = person
	println(name + " : " + age)
	println(n + " : " + age)
}
