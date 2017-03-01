object DisapppearedNumbers extends App {
    def findDisappearedNumbers(nums: Array[Int]): List[Int] =
      nums.foldLeft(List.range(1, nums.length).toSet) { (acc, cur) => acc - cur } toList
      
    println(findDisappearedNumbers(Array(4,3,2,7,8,2,3,1)))
}
