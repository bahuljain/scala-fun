object NumberComplement extends App {
  def flip(c: Char): Char = if (c == '1') '0' else '1'
  def complement(x: Int): Int = Integer.parseInt(x.toBinaryString.map(flip), 2)
  
  println(complement(5))
}
