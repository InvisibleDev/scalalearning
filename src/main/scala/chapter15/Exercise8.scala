package chapter15

object Exercise8 extends App{
  @specialized
  def allDifferent[T](arg: T) = s"hello $arg"

  println(allDifferent(1))
  println(allDifferent("hello"))
  println(allDifferent('R'))
}