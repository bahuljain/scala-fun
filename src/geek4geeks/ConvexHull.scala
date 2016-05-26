package geek4geeks

object ConvexHull extends App {

	case class Point(val x: Double, val y: Double) {
		def distance(that: Point): Double =
			Math.sqrt(Math.pow((this.x - that.x), 2) + Math.pow((this.y - that.y), 2))

		def cross(that: Point): Double =
			this.x * that.y - this.y * that.x
	}

	case class Polygon(vertices: Point*) {
		require(vertices.head == vertices.last)

		def perimeter: Double =
			this.vertices.sliding(2).map(p => p(0).distance(p(1))).sum

		def area: Double =
			math.abs(this.vertices.sliding(2).map(p => p(0).cross(p(1))).sum) / 2

	}

	val poly = Polygon(vertices = Point(-2, 0), Point(-2, 10), Point(2, 2), Point(2, 1), Point(-2, 0))

	println(poly.perimeter)
	println(poly.area)
}