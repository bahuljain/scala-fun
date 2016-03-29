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

- Pure OO: Everything is an object :)

## Traits
- thick interfaces
- contains:
	- abstract methods: thin part of the trait's interface
	- concrete methods: implemented in term of the abstract methods which provides richness to the interface.
- cannot have class parameters.
- super calls are statically bound in classes, whereas they are dynamically bound in traits.
