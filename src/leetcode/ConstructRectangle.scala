import Utils.time

object ConstructRectangle extends App {
  def constructRectangle(area: Int) = {
    val init: Int = Math.sqrt(area.toDouble).ceil.toInt
    val L: Int = Iterator.range(init, area).find(area % _ == 0).getOrElse(area)
    (L, area / L)
  }
  
  def constructRectangle1(area: Int) = {
    val init: Int = Math.sqrt(area.toDouble).ceil.toInt
    val L: Int = List.range(init, area).find(area % _ == 0).getOrElse(area)
    (L, area / L)
  }  
  
  println(time { constructRectangle(19421) })
  println(time { constructRectangle1(19421) })
}
