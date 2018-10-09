class Person{
  private var _age = 0

  def age = _age

  def age_=(n: Int) {
    if (_age < 0)
      _age = 0
  }
}

val p = new Person
p.age = -9
