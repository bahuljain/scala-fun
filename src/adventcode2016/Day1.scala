package adventcode2016

import scala.annotation.tailrec
import scala.math.{ cos, sin, toRadians, abs }

case class Vec(u: Double, v: Double) {
	def rotateLeft: Vec = Vec(-v, u)
	def rotateRight: Vec = Vec(v, -u)
	def *(c: Double): Vec = Vec(c * u, c * v)
}

case class Point(x: Double, y: Double) {
	def +(dir: Vec): Point = Point(x + dir.u, y + dir.v)
	def dist(that: Point): Double = abs(x - that.x) + abs(y - that.y)
}

object Day1 extends App {

	def path(start: Point, dir: Vec, size: Int): List[Point] =
		(0 until size).toList map { x => start + dir * x }

	def getVisitedOrHQ(path: List[Point],
		visited: Set[Point]): Either[Set[Point], Point] = path match {
		case Nil => Left(visited)
		case p :: rem_path =>
			if (visited contains p) Right(p)
			else getVisitedOrHQ(rem_path, visited + p)
	}

	@tailrec
	def followGuide(start: Point, dir: Vec,
		guide: List[String], visited: Set[Point],
		HQ: Option[Point]): (Point, Point) = guide match {
		case Nil => (start, HQ.getOrElse(Point(0, 0)))
		case step :: rest_guide => {
			val size = step.tail.toDouble
			val new_dir = (step.head: @unchecked) match {
				case 'L' => dir.rotateLeft
				case 'R' => dir.rotateRight
			}
			val dest = start + (new_dir * size)

			if (HQ.isDefined)
				followGuide(dest, new_dir, rest_guide, visited, HQ)
			else {
				val pathPoints = path(start, new_dir, size.toInt)
				getVisitedOrHQ(pathPoints, visited) match {
					case Left(new_visited) =>
						followGuide(dest, new_dir, rest_guide, new_visited, HQ)
					case Right(new_HQ) =>
						followGuide(dest, new_dir, rest_guide, visited, Some(new_HQ))
				}
			}
		}
	}

	val input = "L5, R1, R3, L4, R3, R1, L3, L2, R3, L5, L1, L2, R5, L1, R5, R1, L4, R1, R3, L4, L1, R2, R5, R3, R1, R1, L1, R1, L1, L2, L1, R2, L5, L188, L4, R1, R4, L3, R47, R1, L1, R77, R5, L2, R1, L2, R4, L5, L1, R3, R187, L4, L3, L3, R2, L3, L5, L4, L4, R1, R5, L4, L3, L3, L3, L2, L5, R1, L2, R5, L3, L4, R4, L5, R3, R4, L2, L1, L4, R1, L3, R1, R3, L2, R1, R4, R5, L3, R5, R3, L3, R4, L2, L5, L1, L1, R3, R1, L4, R3, R3, L2, R5, R4, R1, R3, L4, R3, R3, L2, L4, L5, R1, L4, L5, R4, L2, L1, L3, L3, L5, R3, L4, L3, R5, R4, R2, L4, R2, R3, L3, R4, L1, L3, R2, R1, R5, L4, L5, L5, R4, L5, L2, L4, R4, R4, R1, L3, L2, L4, R3"
	//	val input = "R5, L2, L2, L8"
	//	val input = "R2, R2, R2"
	//	val input = "R2, L3"
	//	val input = "R8, R4, R4, R8"

	val guide = input.split(", ").toList
	val start = Point(0, 0)
	val res = followGuide(start, Vec(0, 1), guide, Set(), None)
	println("Distance from start to destination: " + res._1.dist(start))
	println("Distance from start to HQ: " + res._2.dist(start))

}