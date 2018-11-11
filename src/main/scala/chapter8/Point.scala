package chapter8

class Point private(val coordinates: Long) extends AnyVal

object Point {
  def apply(x: Int, y: Int) = {
    val coordinates:Long = (x << 32) | y
    new Point(coordinates)
  }
}


object Main extends App{
  val p = Point(3, 5)
  print(p.coordinates)
}