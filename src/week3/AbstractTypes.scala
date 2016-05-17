package week3

abstract class Key(name: String) {
	type Value
}

//import AwesomeDB.Key
class AwesomeDB {
	import collection.mutable.Map
	val data = Map.empty[Key, Any]
	def get(key: Key): Option[key.Value] = data.get(key).asInstanceOf[Option[key.Value]]
	def set(key: Key)(value: key.Value): Unit = data.update(key, value)
}

trait IntValued extends Key {
	type Value = Int
}

trait StringValued extends Key {
	type Value = String
}

object Keys {
	val foo = new Key("foo") with IntValued
	val bar = new Key("bar") with StringValued
}

object AbstractTypes extends App {
	val dataStore = new AwesomeDB
	dataStore.set(Keys.foo)(23)
	println(dataStore.get(Keys.foo))
	dataStore.set(Keys.bar)("23")
	println(dataStore.get(Keys.bar))
}