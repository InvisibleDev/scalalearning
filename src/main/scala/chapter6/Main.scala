package chapter6

object Main extends App{
  val initBalance = args(0).toFloat
  println(Account(initBalance).balance)
}
