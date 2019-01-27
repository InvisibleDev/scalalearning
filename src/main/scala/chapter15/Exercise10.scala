package chapter15

object Exercise10  extends App {
  def fact(n: Int, initValue: Double = 1): Double = {
    //assert(n >= 0)
    if (n == 0)
      initValue
    else
      fact(n - 1, n * initValue)
  }

  println(fact(30))
}
