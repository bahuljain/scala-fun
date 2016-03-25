package week3

abstract class Element {
	def demo() {
		println("Element")
	}
}

class ArrayElement extends Element {
	override def demo() {
		println("ArrayElement")
	}
}

class LineElement extends ArrayElement {
	override def demo() {
		println("LineElement")
	}
}

class UniformElement extends Element {
	def invokeDemo(e: Element) {
		e.demo()
	}
}

object Elements extends App {
	val ue = new UniformElement()

	ue.invokeDemo(new ArrayElement)
	ue.invokeDemo(new LineElement)
	ue.invokeDemo(new UniformElement)
}