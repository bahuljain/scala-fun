package adventcode2016

import scala.collection.immutable.Queue
import scala.io.Source

object Bot {
	def apply(n: Int, chips: List[Int]): Bot =
		if (chips.length == 1) Bot(n, chips(0)) else Bot(n, chips(0), chips(1))
}

case class Bot(n: Int, low: Int = Integer.MAX_VALUE, high: Int = Integer.MAX_VALUE) {
	type Workforce = Map[Int, Bot]
	override def toString: String = if (n >= 0) "(" + low + ", " + high + ")" else "" + low
	def take(chip: Int): Bot = if (chip < low) Bot(n, chip, low) else Bot(n, low, chip)
	def canGive(): Boolean = low != Integer.MAX_VALUE && high != Integer.MAX_VALUE
	def give(l: Int, h: Int, workforce: Workforce): Workforce = {
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
	type Workforce = Map[Int, Bot]

	val filename = "src/adventcode2016/day10_input.txt"
	val instructions = Queue(Source.fromFile(filename).getLines.toList: _*)
	val r_take = """value (\d+) goes to bot (\d+)""".r
	val r_give = """bot (\d+) gives low to (bot|output) (\d+) and high to (bot|output) (\d+)""".r

	val bots: Workforce = instructions.toList collect {
		case r_take(chipN, botN) => (botN.toInt, chipN.toInt)
	} groupBy { _._1 } mapValues { _.map(e => e._2).sorted } map { e => (e._1, Bot(e._1, e._2)) }

	def solve(instructions: Queue[String], bots: Workforce): Unit =
		if (instructions.isEmpty) println(bots.map(e => (-(e._1 + 1), e._2)).mkString("\n"))
		else {
			val (cmd, ins) = instructions.dequeue
			cmd match {
				case r_give(srcN, ldT, ldN, hdT, hdN) => bots.get(srcN.toInt) match {
					case Some(bot) => if (bot.canGive) {
						if (bot.low == 17 && bot.high == 61) println("The bot that compares 17 and 61 is " + srcN);
						val l = if (ldT == "output") -ldN.toInt - 1 else ldN.toInt
						val h = if (hdT == "output") -hdN.toInt - 1 else hdN.toInt
						solve(ins, bot.give(l, h, bots));
					} else
						solve(ins.enqueue(cmd), bots)
					case None => solve(ins.enqueue(cmd), bots)
				}
				case _ => solve(ins, bots)
			}
		}
	solve(instructions, bots)
}