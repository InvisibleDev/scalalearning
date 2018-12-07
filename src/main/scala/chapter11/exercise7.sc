class BitSequence(val binaryLong: Long) {
  override def toString = binaryLong.toBinaryString

  def apply(pos: Int) = toString.lift(pos)
  def update(pos: Int, turnOn: Boolean) = {
    val newVal = if (turnOn) binaryLong | (1 << pos) else binaryLong & (1 << pos)
    new BitSequence(newVal)
  }
}

val b = new BitSequence(100)
b(4)
b(4) = true
