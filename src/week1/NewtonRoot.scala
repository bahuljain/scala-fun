package week1

object NewtonsRoot extends App {
	// Finding square root of a number using Newton's method
	println( "Newton's root method" )

	def abs( x: Double ): Double = if ( x < 0 ) -x else x

	def sqrt( x: Double ): Double = {
		def goodGuess( guess: Double, x: Double ): Boolean =
			Math.abs( guess * guess - x ) < 0.001

		def sqrtIter( x: Double, guess: Double ): Double =
			if ( goodGuess( guess, x ) ) guess
			else sqrtIter( x, improve( guess, x ) )

		def improve( guess: Double, x: Double ): Double =
			( guess + x / guess ) / 2

		sqrtIter( x, 1.0 )
	}

	println( sqrt( 2 ) ) //> res0: Double = 1.4142156862745097
	println( sqrt( 4 ) ) //> res1: Double = 2.0000000929222947
	println( sqrt( 3 ) ) //> res2: Double = 1.7321428571428572
}