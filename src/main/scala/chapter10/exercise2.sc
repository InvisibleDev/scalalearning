class OrderedPoint(x: Int, y: Int) extends java.awt.Point(x, y) with scala.math.Ordered[java.awt.Point]{
  override def compare(that: java.awt.Point): Int = {
    if ((this.x == that.x) && (this.y == that.y))
      0
    else if ((this.x <= that.x) && (this.y < that.y))
      -1
    else
      1
  }
}

val p1 = new OrderedPoint(2, 3)
val p2 = new OrderedPoint(3, 4)
require(p1 < p2)
require(p2 == p2)
