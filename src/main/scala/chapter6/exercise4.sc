class Point(x: Float, y: Float)

object Point {
  def apply(x: Float, y: Float): Point = new Point(x, y)
}

Point(3, 4)