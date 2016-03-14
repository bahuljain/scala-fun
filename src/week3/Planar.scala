package week3

trait Planar {
	def height: Int
	def width: Int
	def surface: Int = height * width
}

/*
class Square extends Shape with Planar {
	def height = 20
	def width = 20
}
*/ 