import java.awt.Rectangle

class Point(val x: Int, val y: Int)
class Square(corner: Point, width: Int) extends Rectangle(corner.x, corner.y, width, 0) {
  def this(width: Int) = this(new Point(0, 0), width)
  def this() = this(new Point(0, 0), 0)
}

val s = new Square()
s.x
s.y
s.width