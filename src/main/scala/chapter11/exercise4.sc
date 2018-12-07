class Money(d: Int, c: Int) {
  private val DollarToCent = 0.01
  private val CentsToDollar = 100
  val dollars = if (c > 0) d + c / CentsToDollar else d + c / CentsToDollar - 1
  val cents = if (c > 0) c % CentsToDollar else CentsToDollar + c % CentsToDollar

  override def toString: String = s"${"$"}$dollars $cents cents"

  override def equals(obj: Any): Boolean =
    obj match {
      case obj: Money => dollars == obj.dollars && cents == obj.cents
      case _ => false
    }

  def +(that: Money) = new Money(dollars + that.dollars, cents + that.cents)
  def -(that: Money) = new Money(dollars - that.dollars, cents - that.cents)

  // no * or / since doing it separately for dollars and cents doesn't make any sense
}

val a = new Money(1, 75)
val b = new Money(0, 50)

assert(a + b == new Money(2, 25), a+b)
assert(a - b == new Money(1, 25), a-b)