class Creature {
  def range: Int = 10
  val env: Array[Int] = new Array[Int](range)
}

class Ants extends Creature {
  override def range = 2
}

val a = new Ants
a.env.length