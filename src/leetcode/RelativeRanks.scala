package leetcode

object RelativeRanks extends App {
  def findRelativeRanks(nums: List[Int]): List[String] = {
    val ranks: Map[Int, Int] = nums.sortBy(-_)
      .zipWithIndex
      .map { p => p._1 -> (p._2 + 1) } toMap

    nums map { n =>
      (ranks.get(n): @unchecked) match {
        case Some(1) => "Gold Medal"
        case Some(2) => "Silver Medal"
        case Some(3) => "Bronze Medal"
        case Some(x) => x.toString
      }
    }
  }

  println(findRelativeRanks(List(2, 5, 1, 3, 4)) mkString (", "))
}
