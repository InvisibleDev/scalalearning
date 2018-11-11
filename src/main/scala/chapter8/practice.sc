class Creature {
  val range = 10
  val env = new Array[Int](range)

  override def equals(obj: Any): Boolean = ???
}

class Ants extends {override val range = 2} with Creature {
}

class MilTime private(val time: Int) extends AnyVal{
  def hours = time / 60
}
object MilTime {
  def apply(time: Int): MilTime = {
    require(time > 0, "Time can't be negative")
    new MilTime(time)
  }
}

val a = new Ants
a.env.length
val c = new Creature
c.env.length