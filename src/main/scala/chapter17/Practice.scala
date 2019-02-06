package chapter17

import java.time.LocalTime
import scala.concurrent.ExecutionContext.Implicits.global

import scala.concurrent.Future

object Practice extends App {
  Future{
    Thread.sleep(10000)
    println(s"This is the future ${LocalTime.now}")
  }
  println(s"This is the present at ${LocalTime.now}")
  Thread.sleep(10001)
}
