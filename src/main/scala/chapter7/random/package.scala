package chapter7

package object random {
  // Exercise 3
  private[this] val a = 1664525
  private[this] val b = 1013904223
  private[this] val n = 32
  private[this] var previous:Double = 1

  def nextInt= {
    previous = (previous * a + b) % math.pow(2, n)
    previous.toInt
  }
  def nextDouble = {
    previous = (previous * a + b) % math.pow(2, n)
    previous
  }
  def setSeed(seed: Int): Unit ={
    previous = seed
  }
}