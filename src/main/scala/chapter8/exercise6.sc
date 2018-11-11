class Point(x: Double, y: Double)

abstract class Shape {
  def centerPoint: Point
}

class Rectangle(val centerPoint: Point) extends Shape
class Circle(val centerPoint: Point) extends Shape