# Scala Fun

Learning Scala

- `mkString(sep)` is a similar to join in python. Loved that feature in python.

- `" " * 3` replicates the string 3 times. Very very awesome and useful.

- the awesome multiline feature, with formatting options. Also no need to escape
single and double quotes.

	```scala
	val s = """This is known as a
	|"multiline" string
	| or 'heredoc' syntax.""" stripMargin
	```

- `s"1 + 1 = ${1 + 1}"` is the cool string interpolation technique. Use `f"..."`
for type safe interpolation.

- `def echo(args: String*)` denotes repeated parameters similar to kwargs in
python. It passes a variable length argument list. Equivalent to Array[String]

- to pass an array as a repeated parameter append by `: _*` like `echo(arr: _*)`

- `@tailrec` annotation gives warning at compile time if the function is not
tail recursive.

- `fn.curried` converts a multiple parameter function to a curried function. The
reverse of that is `Function.uncurried(fn)`.

- `add(_: Int, 10): Int` is a **partially applied function**, that returns a function
that takes an Int and returns an Int. Somewhat similar to currying..

- `flatmap` is a complete genius.

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

- to create a copy of an object with some changes in initialization of constructor
parameters use `obj.copy(arg = something)`

- `require(denom != 0)` is really cool construct that puts a condition on the
arguments of a class or method definition.

- Scala supports Rank-1 polymorphism. That means generic functions cannot take
generic functions as arguments.

- for-comprehension translates to a composition of `flatMap`, `withFilter` and
`map	`

## [Function Composition](src/week2/FunctionChaining.scala)

- `f compose g` returns a function that first applies `g` on the argument and then
applies function `f` to the result of that.

- `f andThen g` returns a function that first applies `f` on the argument and then
applies function `g` to the result of that.

- to chain multiple functions that just transform data without changing type we
can use `Function.chain()` and pass the sequence of functions to it. **coolest shit ever**

	```scala
	val pipeline = Function.chain(Seq(
  	addMissingSubject,
  	checkSpelling,
  	removeInappropriateLanguage,
  	addAdvertismentToFooter
	))
	```

## [Partially Defined Functions](src/week5/PartialFunctions.scala)

- defined only on specific inputs; really concise and helpful at times. Use the
`isDefinedAt` method to check if a partial function is defined for a particular
input.

- combination of map and filter on lists.

	```scala
	val wordFrequencies = ("habitual", 6) :: ("and", 56) :: ("consuetudinary", 2) ::
		("additionally", 27) :: ("homely", 5) :: ("society", 13) :: Nil

	println(wordFrequencies.collect {
		case (w, f) if f > 3 => w
	})
	```

- provide means to be chained, allowing for a neat functional alternative to the [chain of responsibility pattern](https://en.wikipedia.org/wiki/Chain-of-responsibility_pattern) from OOP.

- `fooHandler orElse barHandler orElse bazHandler` is a chain of partial
functions that passes on control to the next function if the current one is not
defined on a particular input.

- `pf.lift` converts a partial function to a normal function that returns
`Some[A]` for inputs that are defined by the partial function and a `None`
otherwise.

- `Function.unlift(f)` converts a function that returns an `Option` to a partial function.

## Pattern Matching

- **Typed Patterns**: types in patterns allowed (wow).

	```scala
	case x : List[Any] =>
	case y : Any =>
	```

- **Patterns in value definitions**.

	```scala
	val person: User = User("bahul", 23)
	val User(name, age) = person
	```

- **Patterns in for-comprehensions**.

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

- `(x: @switch) match { ... }` - annotation provides a warning if the match
expression cannot be compiled down to a `tableswitch` or a `lookupswitch` for
faster performance.

## [Option Type](src/week5/OptionType.scala)

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

## Error Handling with [Try](/src/week5/TryErrorHandling.scala)

- clean way to handle exceptions. Enclose block of code that might throw an
exception in a Try construct. Return type is of instance `Try[A]` that can
either have a value `Success(A)` or `Failure(exception)`.

	```scala
	def get(arr: Array[Int], pos: Int): Try[Int] = Try(arr(pos))

	val arr = Array(1, 2, 3, 4, 5, 6, 7)
	val success = get(arr, 5) // Success(6)
	val fail = get(arr, -1) // Failure(java.lang.ArrayIndexOutOfBoundsException: -1)
	```

- Again, like Option Type, this type can also be viewed as a Collection, so all
map, flatMap, filter, foreach, etc functions can be applied.

- `filter` returns a `Failure` if predicate does not hold true or the original
value is a Failure else it returns Success.

- using in for comprehensions

	```scala
	def parseURL(url: String): Try[URL] = Try(new URL(url))

	def getURLContent(url: String): Try[Iterator[String]] =
		for {
			url <- parseURL(url)
			connection <- Try(url.openConnection())
			is <- Try(connection.getInputStream)
			source = Source.fromInputStream(is)
		} yield source.getLines()
	```

#### Recover

- takes a partial function and returns another Try.
	- Success -> Success
	- Failures which partial function handles -> Success
	- not handled failures -> Failure.

	```scala
	val value = get(arr, -1) recover {
		case e: java.lang.ArrayIndexOutOfBoundsException => Int.MinValue
	}
	```

## [Either Type](/src/week5/OptionType.scala)

- `Either[A, B]` instance contains an instance of either `A` in `Left` or `B` in
`Right`. Here `Left` and `Right` are the two subtypes of `Either` type.

- general-purpose type for use whenever you need to deal with situations where the
result can be of one of two possible types.

- Used most popularly in error handling and by convention `Left` holds the error
and `Right` holds the success value.

	```scala
	def get(arr: Array[Int], pos: Int): Either[String, Int] = {
		if (pos < 0 || pos >= arr.length) Left("Array Index Out of Bounds.")
		else Right(arr(pos))
	}
	```

- Need to apply `left` or `right` projection before using map, flatMap and all
other cool functions.

- `toOption` converts the projection to Option type. The projected value becomes
`Some` and the other one becomes `None`.

- `fold` is another useful function that takes two functions, one that deals with
the Left result and other that deals with the Right result both of which return
result of the same type.

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

## [Type Classes](/src/week3/TypeClasses.scala)

- ad-hoc (method overloading) and retroactive polymorphism

- creating a type class
	```scala
	trait NumberLike[T] {
		def plus(x: T, y: T): T
		def divide(x: T, y: Int): T
		def minus(x: T, y: T): T
	}
	```
- members of type classes are usually singleton objects. They can be created by
extending the type class.

- type class members become implicitly available by using the `implicit` keyword
before each of the type class implementation.

	```scala
	object NumberLike {
		implicit object NumberLikeDouble extends NumberLike[Double] { ... }
		implicit object NumberLikeInt extends NumberLike[Int] { ... }
	}
	```

- coding up against type classes:
	```scala
	def mean[T](xs: Vector[T])(implicit ev: NumberLike[Double]): T = { ... }
	```

- the `implicit` second parameter in the above definition constrains the parameter types
to a specific type class.

- `@implicitNotFound` can be used to customize the error message obtain when no
implicit value is found.

- a nested type is bound to a specific instance of the outer type, not the outer
type itself. see [path-dependent types](src/week3/PathDependentTypes.scala)...

## [Abstract Members](src/week3/Abstract.scala)
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

## [Futures](/src/week5/FutureType.scala) and Promises

- beats callback system of Node.js like a pro.

- `Future[T]`
	- container of computation that eventually results to a type `T`.
	- If computation fails or does not complete, it holds an exception.
	- read-only interface. write-once.
	- used to encapsulate operations that need to computed concurrently in a non-blocking way.
	- assigns a new thread to the computation in a Future container.


	```scala
	def grind(beans: CoffeeBeans): Future[GroundCoffee] = Future {
	  println("start grinding...")
	  Thread.sleep(Random.nextInt(2000))
	  if (beans == "baked beans") throw GrindingException("are you joking?")
	  println("finished grinding...")
	  s"ground coffee of $beans"
	}
	```

- `Promise`
	- Companion type that allows you to complete a `Future` by putting a value into it.
	- you can complete a promised with either a `Success` or a `Failure`.
	- To complete a `Promise` with a success, you call its success method, passing
	it the value that the `Future` associated with it is supposed to have.

	```scala
	val p = Promise[TaxCut]()

	// Successful promise
	p.success(TaxCut(20))

	// Failed promise
	p.failure(LameExcuse("global economy crisis"))
	```

## SBT

- build tool for scala applications

- dependency management handled by **Apache Ivy**, therefore all Java projects
created for Maven are also available with SBT.

- those that aren't on Ivy/Maven can be simply placed in the project's `lib`
folder, and SBT will automatically find them.

- use `sbtmkdirs` script or `Giter8` to create new project.

- `sbt compile` to compile the project. `~ compile` to auto-recompile when
source code changed.

- `sbt run` to run the project.

- `sbt package` to package your project as a JAR file.

- `jar tvf target/scala-x/basic_x-1.0.jar` to list contents of JAR.

- `scala tvf target/scala-x/basic_x-1.0.jar` to execute `main` using scala
interpreter.

- `doc` generates API documentation from Scala source code using `scaladoc`.

- `package-doc` creates JAR with docs.

- `update` updates external dependencies

## Monads

- the class of data structures on which functions such as `map` and `flatMap`
can be applied to are called **monads**.

- monad M is a parametric type `M[T]` with `flatMap` and `unit` operations.

	```scala
	trait M[T] {
		def flatMap[U](f: T => M[U]): M[U]
	}

	def unit[T](x: T): M[T]
	```

- `unit` functions for some common monads:

	1. **List**:  unit(x) ==> List(x)
	1. **Set**:  unit(x) ==> Set(x)
	1. **Option**:  unit(x) ==> Some(x)
	1. **Generator**:  unit(x) ==> single(x)

### Monad Laws

1. Associativity: `m flatMap f flatMap g == m flatMap (x => f(x) flatMap g)`
2. Left Unit: `unit(x) flatMap f == f(x)`
3. Right Unit: `m flatMap unit == m`

- `Try` is not monad since left unit law fails. `Try(expr) flatMap f != f(expr)`
since left-hand side never raises a fatal exception but the right hand side can.
