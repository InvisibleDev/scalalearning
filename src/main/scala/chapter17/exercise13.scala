package chapter17

import java.math.BigInteger

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.concurrent.{Await, Future, Promise}

object exercise13 extends App {
  val NumOfAvailableThreads = 8
  val firstPalindromicPrime = Promise[Long]()

  def isPalindrome(number: Long) = (number > 9) && (number.toString == number.toString.reverse)

  def searchForPalindromicPrime(start: Long, end: Long, certainty: Int = 4) {
    (start + 1).to(end).foreach { number =>
      if ((!firstPalindromicPrime.isCompleted) && isPalindrome(number))
        if (BigInteger.valueOf(number).isProbablePrime(certainty))
          firstPalindromicPrime.success(number)
    }
  }

  def defineRanges(start: Long, end: Long, increment: Int) = {
    val rangeBorders = start.to(end, increment)
    val last = rangeBorders.last
    if (last == end)
      rangeBorders.zip(rangeBorders.tail)
    else
      rangeBorders.zip(rangeBorders.tail) :+ (last, end)
  }

  def divideByRangesAndSearchForPalindromicPrime(start: Long, end: Long, certainty: Int = 4) {
    val increment = (end - start) / NumOfAvailableThreads
    val ranges = defineRanges(start, end, increment.toInt)
    ranges.foreach(r => Future(searchForPalindromicPrime(r._1, r._2, certainty)))
  }

  divideByRangesAndSearchForPalindromicPrime(1, 10000000)
  val palindromePrime = Await.result(firstPalindromicPrime.future, 10.seconds)
  println(s"First palindrome prime number is $palindromePrime")
}
