package adventcode2016

import scala.collection.immutable.Queue
import scala.io.Source

case class Bot(n: String, low: Int = Integer.MAX_VALUE, high: Int = Integer.MAX_VALUE) {
	override def toString: String = "(" + low + ", " + high + ")"
	def take(chip: Int): Bot = if (chip < low) Bot(n, chip, low) else Bot(n, low, chip)
	def canGive(): Boolean = low != Integer.MAX_VALUE && high != Integer.MAX_VALUE
	def give(l: String, h: String, workforce: Map[String, Bot]): Map[String, Bot] = {
		if (low == 17 && high == 61) println("The bot that compares 17 and 61 is " + n);
		val lo = workforce.get(l) match {
			case Some(bot) => bot.take(low)
			case None => Bot(l).take(low)
		}
		val hi = workforce.get(h) match {
			case Some(bot) => bot.take(high)
			case None => Bot(h).take(high)
		}
		workforce + (l -> lo) + (h -> hi) - n
	}
}

object Day10 extends App {
	val filename = "src/adventcode2016/day10_input.txt"
	val instructions = Queue(Source.fromFile(filename).getLines.toList: _*)
	val r_take = """value (\d+) goes to (bot \d+)""".r
	val r_give = """(bot \d+) gives low to ((bot|output) \d+) and high to ((bot|output) \d+)""".r

	def solve(instructions: Queue[String], bots: Map[String, Bot]): Unit =
		if (instructions.isEmpty) println(bots.mkString("\n"))
		else {
			val (cmd, ins) = instructions.dequeue
			cmd match {
				case r_give(srcN, l, _, h, _) => bots.get(srcN) match {
					case Some(bot) if (bot.canGive) => solve(ins, bot.give(l, h, bots));
					case _ => solve(ins.enqueue(cmd), bots)
				}
				case r_take(chipN, botN) => bots.get(botN) match {
					case Some(bot) => solve(ins, bots + (botN -> bot.take(chipN.toInt)))
					case None => solve(ins, bots + (botN -> Bot(botN).take(chipN.toInt)))
				}
			}
		}
	solve(instructions, Map())
}