import scala.annotation.tailrec
import Utils.time

object MaxConsecutiveOnes extends App {
  val nums = List(1, 1, 0, 1, 1, 1)

  def findMaxConsecutiveOnes(nums: List[Int]): Int = nums.mkString.split("0").map(_.length).max
  def findMaxConsecutiveOnes1(nums: List[Int]): Int = {
    @tailrec
    def aux(cur: Int, acc: Int, max: Int): Int =
      if (cur == nums.length) Integer.max(max, acc)
      else if (nums(cur) == 1) aux(cur + 1, acc + 1, max)
      else aux(cur + 1, 0, Integer.max(max, acc))
    aux(0, 0, 0)
  }
  
  println(time { findMaxConsecutiveOnes(nums) })
  println(time { findMaxConsecutiveOnes1(nums) })
}
