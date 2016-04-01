package week4

object Erasure {
  def isIntIntMap(x: Any): Boolean = x match {
		//following case will hold true for any Map, not just Int -> Int maps.
		case map: Map[Int, Int] => true
		case _ => false
	}                                         //> isIntIntMap: (x: Any)Boolean
	
	//works correctly
	isIntIntMap(Map(1 -> 1))                  //> res0: Boolean = true
	
	//this is wrong
	isIntIntMap(Map(true -> true))            //> res1: Boolean = true
	
	
	//Arrays are exceptions to erasures
	def isStringArray(x: Any): Boolean = x match {
		case arr: Array[String] => true
		case _ => false
	}                                         //> isStringArray: (x: Any)Boolean
	
	isStringArray(Array("abc"))               //> res2: Boolean = true
	
	isStringArray(Array(1,2,3,4,5))           //> res3: Boolean = false
}