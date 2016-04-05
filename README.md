# Scala Fun

Learning Scala

- `flatmap` is a complete genius.

- `mkString(sep)` is a similar to join in python. Loved that feature in python.

- `" " * 3` replicates the string 3 times. Very very awesome and useful.

- `def echo(args: String*)` denotes repeated parameters similar to kwargs in
python. It passes a variable length argument list. Equivalent to Array[String]

- to pass an array as a repeated parameter append by `: _*` like `echo(arr: _*)`

- `zipWithIndex` should be very useful.

- `Pure OO`  Everything is an object :)

- Scala supports Rank-1 polymorphism

- `abstract override` in traits for stackable modifications.

- types in patterns allowed (typed patterns) (wow).

	```scala
	case x : List[Any] =>
	case y : Any =>
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

- `@unchecked` - annotation in the selector expression of pattern matching
suppresses exhaustive pattern checking for the patterns that follow.

- generic types have default non-variant (or rigid) sub-typing.

- `Queue[+T]` co-variant - if T is sub-type of S then Queue[T] is a sub-type of Queue[S]
- `Queue[-T]` contra-variant - if T is sub-type of S then Queue[S] is a sub-type of Queue[T]

- Lower bounding type parameter of methods can help making classes completely co-variant

	```scala
	class Queue[+T](private val leading: List[T], private val trailing: List[T]) {
		def append[U >: T](x: U) = new Queue[U](leading, x :: trailing) //...
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

#### Tips
- if the behavior will not be reused, then make it a concrete class
- if the behavior needs to be inherited from Java code, then use an abstract class.
- if it might be reused in multiple, unrelated classes, make it a trait. Only traits can be mixed into different parts of the class hierarchy.
- for performance abstract classes are better
- if you don't know anything, start with traits as they provide more flexibility and can be easily changed later on.
