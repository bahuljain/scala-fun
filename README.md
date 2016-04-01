# Scala Fun

Learning Scala

- `flatmap` is a complete genius.

- `mkString(sep)` is a similar to join in python. Loved that feature in python.

- `" " * 3` replicates the string 3 times. Very very awesome and useful.

- `zipWithIndex` should be very useful.

- `Pure OO`  Everything is an object :)

- Scala supports Rank-1 polymorphism

- `abstract override` in traits for stackable modifications.

- types in patterns allowed (typed patterns) (wow).

	```scala
	case x : List[Any] =>
	case y : Any =>
	```

- variables enclosed in back ticks allows them to be used as constant patterns in pattern matching.

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
