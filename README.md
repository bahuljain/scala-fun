# Scala Fun

Learning Scala

- static types in patterns allowed (wow).

	```scala
	case x : List[Any] =>
	case y : Any =>
	```

- `flatmap` is a complete genius.

- `mkString(sep)` is a similar to join in python. Loved that feature in python.

- `" " * 3` replicates the string 3 times. Very very awesome and useful.

- `zipWithIndex` should be very useful.

- `Pure OO`  Everything is an object :)

- Scala supports Rank-1 polymorphism

- `abstract override` in traits for stackable modifications.

- ` `` ` in pattern matching allow variable names to be used as patterns

	```scala
	val pi = Math.pi
	Math.E match {
		case `pi` => "..."
		case _ => "...."
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
