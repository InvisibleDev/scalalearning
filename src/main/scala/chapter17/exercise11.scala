package chapter17

import java.time.LocalDateTime
import java.util.concurrent.Executors

import scala.concurrent.{Await, ExecutionContext, ExecutionContextExecutor, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

object exercise11 extends App{
  val pool = Executors.newCachedThreadPool()
  implicit val ec: ExecutionContextExecutor = ExecutionContext.fromExecutor(pool)
  def sleepingFutures(num: Int) = {
    val futures = Seq.fill(num)(
      Future{
        Thread.sleep(10000)
        print(s"${LocalDateTime.now()} | ")
      }
    )
    Future.sequence(futures)
  }
  println("4 futures:")
  Await.result(sleepingFutures(4), 11.seconds)

  println("\n40 futures with cached thread pool:") //since thread is blocking, ec allocates more threads
  val startTime = System.nanoTime()
  Await.result(sleepingFutures(40), 11.seconds)
  val endTime = System.nanoTime()
  println(s"\nTotal run time is: ${(endTime - startTime)/math.pow(10, 9)} seconds")
}
