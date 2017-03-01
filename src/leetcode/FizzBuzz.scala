object FizzBuzz extends App {
  def fizzbuzz(n: Int): List[String] = (1 to n).toList map { i =>
    if (i % 15 == 0) "FizzBuzz"
    else if (i % 5 == 0) "Buzz"
    else if (i % 3 == 0) "Fizz"
    else i.toString
  }
  
  println(fizzbuzz(15))
}
