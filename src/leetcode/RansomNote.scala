package leetcode

object RansomNote extends App {
  def canConstruct(ransomNote: String, magazine: String): Boolean = {
    val mag = magazine.groupBy(identity).mapValues(_.length)
    ransomNote.groupBy(identity).mapValues(_.length) forall { e =>
      mag.get(e._1) match {
        case Some(count) => e._2 <= count
        case None => false
      }
    }
  }
  
  println(canConstruct("ac", "aab"))
}
