object Conversions {
  private[this] val INCH_TO_CM_COEF = 2.54
  private[this] val GALLON_TO_LITRE_COEF = 4.54609
  private[this] val MILE_TO_KM_COEF = 1.609

  def inchesToCentimeters(inches: Double) = inches * INCH_TO_CM_COEF
  def gallonsToLitres(gallons: Double) = gallons * GALLON_TO_LITRE_COEF
  def milesToKilometers(miles: Double) = miles * MILE_TO_KM_COEF
}

Conversions.inchesToCentimeters(10)
Conversions.gallonsToLitres(10)
Conversions.milesToKilometers(5)