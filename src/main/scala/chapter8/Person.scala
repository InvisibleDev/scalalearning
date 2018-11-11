package chapter8

class Person(val name: String) {
  override def toString: String = s"${getClass.getName}[name=$name]"
}
