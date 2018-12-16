package chapter13
import scala.collection.mutable

object Exercise11 extends App {
  val numOfWords = 1000000
  val str = "Hello " * numOfWords

  def updateFrequencies(frequencies: mutable.HashMap[Char, Int], c: Char) = {
    frequencies(c) = frequencies.getOrElse(c, 0) + 1
    frequencies
  }

  def combine(freq1: mutable.HashMap[Char, Int], freq2: mutable.HashMap[Char, Int]) = {
    for ((c, n) <- freq2)
      freq1(c) = freq1.getOrElse(c, 0) + n
    freq1
  }
  val res = str.par.aggregate(new mutable.HashMap[Char, Int]())(updateFrequencies, combine)
  require(res == mutable.HashMap('H' -> numOfWords, 'e' -> numOfWords, 'l' -> numOfWords * 2, 'o' -> numOfWords, ' ' -> numOfWords))
  print(res)
}
