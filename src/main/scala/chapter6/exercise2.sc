class UnitConversion(conversionRate: Double) {
  def convert(unit: Double) = unit * conversionRate
}

object InchesToCentimeters extends UnitConversion (2.54) {}

object GallonsToLitres extends UnitConversion (4.54609) {}

object MilesToKilometers extends UnitConversion (1.609) {
  def apply(inches: Double) =  convert(inches)
}

InchesToCentimeters.convert(10)
GallonsToLitres.convert(10)
MilesToKilometers.convert(5)