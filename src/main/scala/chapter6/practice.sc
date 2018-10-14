object Colors extends Enumeration {
  val Red, Velvet, Green = Value
}

Colors.Velvet

object ColorsAdvanced extends Enumeration {
  val Red = Value("Red Color")
  val Velvet = Value("Velvet Color")
  val Green = Value("Green Color")
}

ColorsAdvanced.withName("Green Color")