class Employee(val name: String, var salary: Double) {

  def this() = this("John Q. Public", 0)
}

val e = new Employee()

// below class is less flexible because we can't reset the name
class EmployeeRewrite {
  val name = "John Q. Public"
  var salary = 0.0
}

val ew = new EmployeeRewrite