class Person(fullname: String) {
  val firstName :: lastName = fullname.split(" ").toList
}

val p = new Person("Rustam Aliyev")
p.firstName