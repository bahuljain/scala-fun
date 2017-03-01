package leetcode

object DetectCapital extends App {
  def isCapital(c: Char): Boolean = c >= 'A' && c <= 'Z'
  def detectCapitalUse(word: String): Boolean = word.toList match {
    case first :: rest if (isCapital(first)) => rest.forall(!isCapital(_)) || rest.forall(isCapital)
    case word                                => word.forall(!isCapital(_))
  }

  println(detectCapitalUse("word"))
  println(detectCapitalUse("USA"))
  println(detectCapitalUse("Google"))
  println(detectCapitalUse("FlaG"))
}
