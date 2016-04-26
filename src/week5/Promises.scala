package week5

import concurrent.Future
import concurrent.ExecutionContext.Implicits.global
import concurrent.Promise

case class TaxCut(reduction: Int)

object Promises extends App {
	def redeemCampaignPledge(): Future[TaxCut] = {
		val p = Promise[TaxCut]()

		Future {
			println("Starting the new legislative period.")
			Thread.sleep(2000)
			p.success(TaxCut(20))
			println("We reduced the taxes! You must reelect us!!!!1111")
		}

		p.future
	}
}