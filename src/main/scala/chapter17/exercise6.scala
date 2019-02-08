package chapter17

import com.sun.net.httpserver.Authenticator.Success

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object exercise6 extends App{

  def repeat[T](action: => T, until: T => Boolean, successAction: => T): Future[T] = {
    val untilRes = Future(until(action))
    untilRes.flatMap(r => if (r) Future(successAction) else repeat(action, until, successAction))
  }

  def enterPassword() = io.StdIn.readLine("Enter the password:\n")

  def pwdSuccessful = {
    println("Password is accepted!")
    ""
  }

  def passwordChecker = { (p: String) =>
    Thread.sleep(1000)
    p == "secret"
  }

  repeat(enterPassword, passwordChecker, pwdSuccessful)
  //Thread.sleep(20000)
}
