package week1

object NewtonRoot {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(127); 
  // Finding square root of a number using Newton's method
  println("Newton's root method");$skip(53); 

  def abs(x: Double): Double = if (x < 0) -x else x;System.out.println("""abs: (x: Double)Double""");$skip(94); 

  def goodGuess(guess: Double, x: Double): Boolean =
    Math.abs(guess * guess - x) < 0.001;System.out.println("""goodGuess: (guess: Double, x: Double)Boolean""");$skip(127); 

  def sqrtIter(x: Double, guess: Double): Double =
    if (goodGuess(guess, x)) guess
    else sqrtIter(x, improve(guess, x));System.out.println("""sqrtIter: (x: Double, guess: Double)Double""");$skip(79); 

  def improve(guess: Double, x: Double): Double =
    (guess + x / guess) / 2;System.out.println("""improve: (guess: Double, x: Double)Double""");$skip(50); 

  def sqrt(x: Double): Double = sqrtIter(x, 1.0);System.out.println("""sqrt: (x: Double)Double""");$skip(11); val res$0 = 

  sqrt(2);System.out.println("""res0: Double = """ + $show(res$0));$skip(10); val res$1 = 
  sqrt(4);System.out.println("""res1: Double = """ + $show(res$1));$skip(10); val res$2 = 
  sqrt(3);System.out.println("""res2: Double = """ + $show(res$2))}
}
