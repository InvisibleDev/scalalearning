class Car(val manufacturer: String,
          val modelName: String,
          val modelYear: Int,
          var licensePlate: String) {
  def this(manufacturer: String, modelName: String) = this(manufacturer, modelName, -1, "")
  def this(manufacturer: String, modelName: String, modelYear: Int) = this(manufacturer, modelName, modelYear, "")
}

val c1 = new Car("Toyota", "Yaris")
val c2 = new Car("Toyota", "Yaris", 1998)
val c3 = new Car("Toyota", "Yaris", 1998, "10BU878")
c3.licensePlate = "20TT234"