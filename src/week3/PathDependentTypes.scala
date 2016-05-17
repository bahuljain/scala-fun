package week3

object PathDependentTypes extends App {
	class A {
		class B
		var b: Option[B] = None
	}

	val a1 = new A
	val a2 = new A
	val b1 = new a1.B
	val b2 = new a2.B

	a1.b = Some(b1)
	a2.b = Some(b2) // if here instead of b2, b1 is placed that will raise a compiler error

	val starTrek = new Franchise("Star Trek")
	val starWars = new Franchise("Star Wars")

	val quark = starTrek.Character("Quark")
	val jadzia = starTrek.Character("Jadzia Dax")

	val luke = starWars.Character("Luke Skywalker")
	val yoda = starWars.Character("Yoda")

	//	starTrek.createFanFiction(luke, quark) // this will not compile
	starTrek.createFanFiction(jadzia, quark)
	starWars.createFanFiction(luke, yoda)

}

class Franchise(name: String) {
	case class Character(name: String)
	def createFanFiction(loveStruck: Character, objectOfDesire: Character) =
		(loveStruck, objectOfDesire)
}