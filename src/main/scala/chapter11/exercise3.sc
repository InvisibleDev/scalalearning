class Fraction(n: Int, d: Int) {
  private val num: Int = if (d == 0) 1 else n * sign(d) / gcd(n, d)
  private val den: Int = if (d == 0) 0 else d * sign(d) / gcd(n, d)

  override def toString() = s"$num/$den"

  override def equals(that: Any): Boolean = {
    that match {
      case that: Fraction =>
      (this.num == that.num) && (this.den == that.den)
      case _ => false
    }
  }

  def sign(i: Int) = if (i > 0) 1 else if (i < 0) -1 else 0
  def gcd(a: Int, b: Int): Int = if (b == 0) math.abs(a) else gcd(b, a % b)

  def +(that: Fraction) = new Fraction(this.num * that.den + that.num * this.den, this.den * that.den)
  def -(that: Fraction) = new Fraction(this.num * that.den - that.num * this.den, this.den * that.den)
  def *(that: Fraction) = new Fraction(this.num * that.num, this.den * that.den)
  def /(that: Fraction) = new Fraction(this.num * that.den, this.den * that.num)
}

val a = new Fraction(5, 6)
val b = new Fraction(3, 4)

assert(a + b == new Fraction(19, 12))
assert(a - b == new Fraction(1, 12))
assert(a * b == new Fraction(5, 8))
assert(a/b == new Fraction(10, 9))