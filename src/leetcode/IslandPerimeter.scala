package leetcode

object IslandPerimeter extends App {
  val grid = Array(
    Array(0, 1, 0, 0),
    Array(1, 1, 1, 0),
    Array(0, 1, 0, 0),
    Array(1, 1, 0, 0))

  def get(grid: Array[Array[Int]], i: Int, j: Int): Int =
    if (i < 0 || j < 0 || i == grid.length || j == grid(0).length) 1
    else if (grid(i)(j) == 0) 1 else 0

  def islandPerimeter(grid: Array[Array[Int]]): Int = (for {
    i <- 0 until grid.length
    j <- 0 until grid(0).length
    if (grid(i)(j) == 1)
  } yield (i, j)) map {
    case (i, j) => get(grid, i, j - 1) + get(grid, i, j + 1) + get(grid, i - 1, j) + get(grid, i + 1, j)
  } sum

  println(islandPerimeter(grid))
}
