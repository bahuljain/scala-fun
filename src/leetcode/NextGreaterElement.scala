package leetcode

object NextGreaterElement extends App {
  def nextGreater(nums1: Array[Int], nums2: Array[Int]) = nums1 map { cur =>
    nums2.dropWhile(_ != cur).find(_ > cur).getOrElse(-1)
  } toList

  println(nextGreater(Array(1, 2, 3), Array(1, 2, 3, 4)))
}
