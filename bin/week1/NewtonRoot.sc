package week1

object NewtonRoot {
  // Finding square root of a number using Newton's method
  println("Newton's root method")                 //> Newton's root method

  def abs(x: Double): Double = if (x < 0) -x else x
                                                  //> abs: (x: Double)Double

  def goodGuess(guess: Double, x: Double): Boolean =
    Math.abs(guess * guess - x) < 0.001           //> goodGuess: (guess: Double, x: Double)Boolean

  def sqrtIter(x: Double, guess: Double): Double =
    if (goodGuess(guess, x)) guess
    else sqrtIter(x, improve(guess, x))           //> sqrtIter: (x: Double, guess: Double)Double

  def improve(guess: Double, x: Double): Double =
    (guess + x / guess) / 2                       //> improve: (guess: Double, x: Double)Double

  def sqrt(x: Double): Double = sqrtIter(x, 1.0)  //> sqrt: (x: Double)Double

  sqrt(2)                                         //> res0: Double = 1.4142156862745097
  sqrt(4)                                         //> res1: Double = 2.0000000929222947
  sqrt(3)                                         //> res2: Double = 1.7321428571428572
}