import scala.util.Random

def randArray(n: Int):Array[Int] =
  for (i <- 0.until(n).toArray) yield Random.nextInt(n)

randArray(10)