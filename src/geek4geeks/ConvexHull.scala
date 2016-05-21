package geek4geeks

object ConvexHull extends App {

	case class Point(val x: Double, val y: Double) {
		def distance(that: Point): Double =
			Math.sqrt(Math.pow((this.x - that.x), 2) + Math.pow((this.y - that.y), 2))
	}

	case class Polygon(vertices: Point*) {
		require(vertices.head == vertices.last)

		def perimeter: Double =
			this.vertices.sliding(2).map(pair => pair(0).distance(pair(1))).sum
	}

	val square = Polygon(vertices = Point(-2, 0), Point(-2, 2), Point(2, 2), Point(2, 0), Point(-2, 0))

	println(square.perimeter)
}