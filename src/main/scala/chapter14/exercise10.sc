def compose(g: Double => Option[Double], f: Double => Option[Double]): Double => Option[Double] = {
  (x: Double) => f(x) match {
    case None => None
    case Some(result) => g(result)
  }
}

def f(x: Double) = if (x!=1) Some(1/(x-1)) else None
def g(x: Double) = if (x >= 0) Some(math.sqrt(x)) else None

val h = compose(g, f)
h(2)
h(1)
h(0)
