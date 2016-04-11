	# Scala Fun

Learning Scala

- `mkString(sep)` is a similar to join in python. Loved that feature in python.

- `" " * 3` replicates the string 3 times. Very very awesome and useful.

- `s"1 + 1 = ${1 + 1}"` is the cool string interpolation technique. Use `f"..."` for type safe interpolation.

- `def echo(args: String*)` denotes repeated parameters similar to kwargs in
python. It passes a variable length argument list. Equivalent to Array[String]

- to pass an array as a repeated parameter append by `: _*` like `echo(arr: _*)`

- `flatmap` is a complete genius.

- Partial Functions
	- unary function defined only on specific inputs.
	- can be really concise and helpful at times.
	- combination of map and filter on lists.
	- provide means to be chained, allowing for a neat functional alternative to the [chain of responsibility pattern](https://en.wikipedia.org/wiki/Chain-of-responsibility_pattern) from OOP.

	```scala
	val wordFrequencies = ("habitual", 6) :: ("and", 56) :: ("consuetudinary", 2) ::
		("additionally", 27) :: ("homely", 5) :: ("society", 13) :: Nil

	println(wordFrequencies.collect {
		case (w, f) if f > 3 => w
	})
	```

- different ways to create a list:

	```scala
	val x = 1 :: 2 :: 3 :: Nil
	val x = List(1,2,3)
	val x = List.range(1, 10) 	//end exclusive
	val x = List.range(0, 10, 2)
	val x = List.fill(3)("foo")
	val x = List.tabulate(5)(n => n * n)
	```

- `zipWithIndex` should be very useful.

- `Pure OO`  Everything is an object :)

- `require(denom != 0)` is really cool construct that puts a condition on the
arguments of a class or method definition.

- Scala supports Rank-1 polymorphism. That means generic functions cannot take
generic functions as arguments.

## Option Type

- `Option` type is also another beauty. Workaround for NullPointerException in Java.

- `isDefined` returns true if the Option type is of instance Some else false.

- `getOrElse` is B-E-A-utiful. Easiest way to deal with Option types.

	```scala
	val x = Some(5)
	x.getOrElse(0) // 0 being the default value if None is obtained from x.
	```

- Option types can be viewed as collection.

- `flatmap` on Option type transforms `Some(Some(Some(5)))` to `Some(5)`

	```scala
	val names: List[Option[String]] = List(Some("Johanna"), None, Some("Daniel"))
	names.map(_.map(_.toUpperCase)) // List(Some("JOHANNA"), None, Some("DANIEL"))
	names.flatMap(xs => xs.map(_.toUpperCase)) // List("JOHANNA", "DANIEL")
	```

- basically you can do all functional operations that are provided for lists or
sets on Option Types as well, for e.g. map, filter, flatten etc.

## Pattern Matching

- types in patterns allowed (typed patterns) (wow).

	```scala
	case x : List[Any] =>
	case y : Any =>
	```

- patterns in value definitions.

	```scala
	val person: User = User("bahul", 23)
	val User(name, age) = person
	```

- really cool way of pattern matching in for comprehensions.

	```scala
	val lists = List(1, 2, 3) :: List.empty :: List(5, 3) :: Nil

	for {
		list @ head :: _ <- lists
	} yield list.size
	```

- variables enclosed in back ticks allows them to be used as constant patterns in
pattern matching.

	```scala
	val pi = Math.pi
	Math.E match {
		case `pi` => "..."
		case _ => "...."
	}
	```

- `_*` - this pattern matches any number of elements in a sequence, including zero elements

	```scala
	list match {
		case List(0, _*) => println("found list starting with 0")
		case _ => println("whatever")
	}
	```

- `case x :: xs @ List(1,2,3) => println(xs)` - this binds the pattern
`List(1,2,3)` to the variable xs which can then be used on the right hand side.
This is similar to OCaml construct `as` in pattern matching.

- `sealed` - sealed class cannot have any subclasses apart from the ones created
in the same file. Important for pattern matching as it restricts the cases
possible, and helps the compiler give concrete warnings while making erroneous
pattern matches.

- `(x: @unchecked) match { ... }` - annotation in the selector expression of pattern matching
suppresses exhaustive pattern checking for the patterns that follow.

## Type Parameterization

- generic types have default non-variant (or rigid) sub-typing.

- `Queue[+T]` co-variant - if T is sub-type of S then Queue[T] is a sub-type of Queue[S]
- `Queue[-T]` contra-variant - if T is sub-type of S then Queue[S] is a sub-type of Queue[T]

- Lower bounding type parameter of methods can help making classes completely co-variant

	```scala
	class Queue[+T](private val leading: List[T], private val trailing: List[T]) {
		def append[U >: T](x: U) = new Queue[U](leading, x :: trailing) //...
	}
	```

## Abstract Members
- abstract fields in scala include: types, vals, vars, and methods.

	```scala
	trait Abstract {
		type T
		def transform(x:T): T
		val initial: T
		var curr: T
	}

	class Concrete extends Abstract {
		type T = String
		def transform(x: String) = x + x
	}
	```

- abstract type in scala is always member of some class or trait, such as `type T` in `Abstract`.

- abstact vals can only be implemented as concrete vals, but abstracts defs can
be implemented as concrete defs or vals.

- abstract vars come with implicit getters and setters.
	```scala
	trait AbstractTime {
		var hour: Int
	}

	// same as above
	trait AbstractTime {
		def hour: Int
		def hour_ = (x: Int)
	}
	```

## Traits
- thick interfaces
- contains:
	- abstract methods: thin part of the trait's interface
	- concrete methods: implemented in term of the abstract methods which provides richness to the interface.
- cannot have class parameters.
- super calls are statically bound in classes, whereas they are dynamically bound in traits.
- stackable modifications (tricky):
	- super classes are stacked in a linear order
	- rightmost, trait is called first, followed by traits inherited to the left of it.
	- `abstract override` in traits for stackable modifications.

#### Tips
- if the behavior will not be reused, then make it a concrete class
- if the behavior needs to be inherited from Java code, then use an abstract class.
- if it might be reused in multiple, unrelated classes, make it a trait. Only traits can be mixed into different parts of the class hierarchy.
- for performance abstract classes are better
- if you don't know anything, start with traits as they provide more flexibility and can be easily changed later on.

## Factory Method and Extractor

- `def unapply(object: S): Option[(T1, ..., Tn)]` extractor for multiple values.

```scala
class User(val name: String, val age: Int)

object User {
	// factory method
	def apply(name: String, age: Int): User = new User(name, age)

	// extractor method
	def unapply(user: User): Option[(String, Int)] = Some(user.name, user.age)
}

object UserTest extends App {
	// factory method called here.
	val person: User = User("bahul", 23)

	// unapply method called here.
	val User(name, age) = person
	val n User a = person
}
```

- with case classes extractors come for free.

- `def unapply(object: S): Boolean` is a boolean extractor. When used in a
pattern, the pattern will match if the extractor returns true. Otherwise the
next case, if available, is tried.

- `x :: xs` or `x #:: xs` or `name User age` Scala also allows extractors to be
used in an infix notation, although it seems more appropriate for lists and
streams

- `def unapplySeq(object: S): Option[Seq[T]]` is an extractor takes an object of
a certain type and de-structures it into a sequence of extracted values, where
the length of that sequence is unknown at compile time.

	```scala
	object Names {
		def unapplySeq(input: String): Option[Seq[String]] = {
			val names = input.split(" ")
			if (names.forall(_.isEmpty())) None
			else Some(names)
		}
	}

	object SequenceExtractor extends App {
		val names: String = "Bahul Zappos Stripe Nivea"

		names match {
			case Names(first, _*) => println(first)
			case _ => println("Nothing")
		}
	}
	```

- `def unapplySeq(object: S): Option[(T1, .., Tn-1, Seq[T])` is an extractor that
combines fixed and variable parameter extraction
