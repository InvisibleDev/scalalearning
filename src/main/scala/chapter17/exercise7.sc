import java.math.BigInteger
import java.util.concurrent.Executors

import scala.concurrent.{Await, ExecutionContext, Future}
import scala.concurrent.duration._

val NumOfAvailableThreads = 8
val pool = Executors.newFixedThreadPool(NumOfAvailableThreads)
implicit val ec = ExecutionContext.fromExecutor(pool)

def countPrimes(start: Long, end: Long, certainty: Int = 4) = (start+1).to(end).count{number =>
  val n = BigInteger.valueOf(number)
  n.isProbablePrime(certainty)
}

def defineRanges(start: Long, end: Long, increment: Int) = {
  val rangeBorders = start.to(end, increment)
  val last = rangeBorders.last
  if (last == end)
    rangeBorders.zip(rangeBorders.tail)
  else
    rangeBorders.zip(rangeBorders.tail) :+ (last, end)
}

def countPrimesParallel(start: Long, end: Long,certainty: Int = 4) = {
  val increment = (end - start) / NumOfAvailableThreads
  val ranges = defineRanges(start, end, increment.toInt)
  val futures = ranges.map(r => Future(countPrimes(r._1, r._2, certainty)))
  Future.reduceLeft(futures)(_ + _)
}

Await.result(countPrimesParallel(1, 10000000), 10.seconds) match {
  case value => println(s"Total number of prime numbers is $value")
  case _ => println("Error")
}