class Point(x: Double, y: Double)
class LabeledPoint(label: String, x: Double, y: Double) extends Point(x, y)

new LabeledPoint("Black Thursday", 1929, 230.07)