package leetcode

object NimGame extends App {
	def canWinGame_?(n: Int): Boolean = !(n % 4 == 0)

	assert(canWinGame_?(7) == true)
	assert(canWinGame_?(12) == false)
}