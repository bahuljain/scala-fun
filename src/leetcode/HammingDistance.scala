object HammingDistance extends App {
  def hammingDistance(x: Int, y: Int): Int =
    x.toBinaryString.reverse.zipAll(y.toBinaryString.reverse, '0', '0')
      .count(e => e._1 != e._2)
  println(hammingDistance(1, 4))
}
