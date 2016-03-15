package greeter

object ScalaWorksheet {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  val x = 2                                       //> x  : Int = 2
  def increase(i: Int) = i + 1                    //> increase: (i: Int)Int
  increase(x)                                     //> res0: Int = 3
  
  val y: Nothing = throw new Exception            //> java.lang.Exception
                                                  //| 	at greeter.ScalaWorksheet$$anonfun$main$1.apply$mcV$sp(greeter.ScalaWork
                                                  //| sheet.scala:10)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$$anonfun$$exe
                                                  //| cute$1.apply$mcV$sp(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:75)
                                                  //| 	at greeter.ScalaWorksheet$.main(greeter.ScalaWorksheet.scala:3)
                                                  //| 	at greeter.ScalaWorksheet.main(greeter.ScalaWorksheet.scala)
}