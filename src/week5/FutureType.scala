package week5

import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.concurrent.duration.Duration
import scala.util.Failure
import scala.util.Random
import scala.util.Success
import scala.util.Try

// Amazing SHIZZZZ. Beats call-backs in node.js like a pro

object FutureType extends App {
	//	println(Random.nextInt(2000))

	type CoffeeBeans = String
	type GroundCoffee = String

	case class Water(temperature: Int)

	type Milk = String
	type FrothedMilk = String
	type Espresso = String
	type Cappuccino = String

	case class GrindingException(msg: String) extends Exception(msg)
	case class FrothingException(msg: String) extends Exception(msg)
	case class WaterBoilingException(msg: String) extends Exception(msg)
	case class BrewingException(msg: String) extends Exception(msg)

	def combine(espresso: Espresso, frothedMilk: FrothedMilk): Cappuccino = "cappuccino"

	def grind(beans: CoffeeBeans): Future[GroundCoffee] = Future {
		println("started grinding coffee...")
		Thread.sleep(5000)
		if (beans == "baked beans") throw GrindingException("Baked Beans cannot be grounded.")
		println("finished grinding...")
		s"ground coffee of $beans"
	}

	def heatWater(water: Water): Future[Water] = Future {
		println("heating water now...")
		Thread.sleep(8000)
		println("hot, it's hot!!")
		water.copy(temperature = 85)
	}

	def frothMilk(milk: Milk): Future[FrothedMilk] = Future {
		println("milk frothing system engaged!")
		Thread.sleep(5000)
		println("shutting down milk frothing system")
		s"frothed $milk"
	}

	def brew(coffee: GroundCoffee, heatedWater: Water): Future[Espresso] = Future {
		println("happy brewing :)")
		Thread.sleep(Random.nextInt(4000))
		println("it's brewed!")
		"espresso"
	}

	def checkTemp(water: Water): Future[Boolean] = Future {
		println("Checking water temperature.")
		(80 to 85).contains(water.temperature)
	}

	def prepareCappuccino(): Future[Cappuccino] = {
		val groundCoffee = grind("arabica beans")
		val heatedWater = heatWater(Water(20))
		val frothedMilk = frothMilk("milk")
		for {
			ground <- groundCoffee
			water <- heatedWater
			foam <- frothedMilk
			espresso <- brew(ground, water)
		} yield combine(espresso, foam)
	}

	// just this may not show any result as the program terminates before the callback method is executed.
	grind("baked beans") onComplete {
		case Success(ground) => println(ground)
		case Failure(ex) => println(ex)
	}

	// to show results we need to await for the result
	val result = Try(Await.result(prepareCappuccino(), Duration(20, "sec")))
	println(result)

}