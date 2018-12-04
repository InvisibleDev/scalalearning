import java.awt.geom.Ellipse2D

trait RectangleLike {
  def getX: Double
  def getY: Double
  def getWidth: Double
  def getHeight: Double

  def setFrame(x:Double, y:Double, w: Double, h: Double)

  def translate(dx: Int, dy: Int): Unit = {
    var oldv = getX
    var newv = oldv + dx
    var width = getWidth
    var height = getHeight
    var x = getX
    var y = getY

    if (dx < 0) { // moving leftward
      if (newv > oldv) { // negative overflow
        if (getWidth >= 0) {
          width += newv - Integer.MIN_VALUE
        }
        newv = Integer.MIN_VALUE
      }
    }
    else { // moving rightward (or staying still)
      if (newv < oldv) { // positive overflow
        if (getWidth >= 0) { // Conceptually the same as:
          width += newv - Integer.MAX_VALUE
          if (getWidth < 0) width = Integer.MAX_VALUE
        }
        newv = Integer.MAX_VALUE
      }
    }
    x = newv
    oldv = getY
    newv = oldv + dy
    if (dy < 0) { // moving upward
      if (newv > oldv) {
        if (getHeight >= 0) {
          height += newv - Integer.MIN_VALUE
        }
        newv = Integer.MIN_VALUE
      }
    }
    else { // moving downward (or staying still)
      if (newv < oldv) {
        if (getHeight >= 0) {
          height += newv - Integer.MAX_VALUE
          if (getHeight < 0) height = Integer.MAX_VALUE
        }
        newv = Integer.MAX_VALUE
      }
    }
    y = newv
    setFrame(x, y, width, height)
  }

  def grow(h: Int, v: Int): Unit = {
    var x0 = getX
    var y0 = getY
    var x1 = getWidth
    var y1 = getHeight
    x1 += x0
    y1 += y0
    x0 -= h
    y0 -= v
    x1 += h
    y1 += v
    if (x1 < x0) { // Non-existant in X direction
      // Final width must remain negative so subtract x0 before
      // it is clipped so that we avoid the risk that the clipping
      // of x0 will reverse the ordering of x0 and x1.
      x1 -= x0
      if (x1 < Integer.MIN_VALUE) x1 = Integer.MIN_VALUE
      if (x0 < Integer.MIN_VALUE) x0 = Integer.MIN_VALUE
      else if (x0 > Integer.MAX_VALUE) x0 = Integer.MAX_VALUE
    }
    else { // (x1 >= x0)
      // Clip x0 before we subtract it from x1 in case the clipping
      // affects the representable area of the rectangle.
      if (x0 < Integer.MIN_VALUE) x0 = Integer.MIN_VALUE
      else if (x0 > Integer.MAX_VALUE) x0 = Integer.MAX_VALUE
      x1 -= x0
      // The only way x1 can be negative now is if we clipped
      // x0 against MIN and x1 is less than MIN - in which case
      // we want to leave the width negative since the result
      // did not intersect the representable area.
      if (x1 < Integer.MIN_VALUE) x1 = Integer.MIN_VALUE
      else if (x1 > Integer.MAX_VALUE) x1 = Integer.MAX_VALUE
    }
    if (y1 < y0) { // Non-existant in Y direction
      y1 -= y0
      if (y1 < Integer.MIN_VALUE) y1 = Integer.MIN_VALUE
      if (y0 < Integer.MIN_VALUE) y0 = Integer.MIN_VALUE
      else if (y0 > Integer.MAX_VALUE) y0 = Integer.MAX_VALUE
    }
    else { // (y1 >= y0)
      if (y0 < Integer.MIN_VALUE) y0 = Integer.MIN_VALUE
      else if (y0 > Integer.MAX_VALUE) y0 = Integer.MAX_VALUE
      y1 -= y0
      if (y1 < Integer.MIN_VALUE) y1 = Integer.MIN_VALUE
      else if (y1 > Integer.MAX_VALUE) y1 = Integer.MAX_VALUE
    }
    setFrame(x0, y0, x1, y1)
  }
}

val egg = new Ellipse2D.Double(5.0, 10.0, 20.0, 30.0) with RectangleLike
println(
  s"""Initial parameters:
     |x=${egg.getX}
     |y=${egg.getY}
     |height=${egg.getHeight}
     |width=${egg.getWidth}""".stripMargin)
egg.translate(10, -10)
println(
  s"""After calling `egg.translate(10, -10)`:
     |x=${egg.getX}
     |y=${egg.getY}
     |height=${egg.getHeight}
     |width=${egg.getWidth}""".stripMargin)
egg.grow(10, 20)
println(
  s"""After calling `egg.grow(10, 20)`:
     |x=${egg.getX}
     |y=${egg.getY}
     |height=${egg.getHeight}
     |width=${egg.getWidth}""".stripMargin)