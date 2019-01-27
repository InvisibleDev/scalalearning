package chapter15

abstract class Exercise2 {
  @deprecated class SomeClass

  @deprecated
  def deprecatedMethod = ???

  def deprecatedArg(@deprecated e:Int)

  @deprecated val deprecatedVal = 20
}
