class Matrix(val rows: Seq[Seq[Int]]) {
  require(rows.forall(_.length == rows.head.length), "All matrix rows should be of equal length")
  val colNum = rows.head.length
  val rowNum = rows.length

  def apply(r: Int, c: Int): Option[Int] = rows.lift(r).flatMap(_.lift(c))

  def +(that: Matrix): Option[Matrix] = {
    if ((colNum == that.colNum) && (rowNum == that.rowNum))
      Some(new Matrix(rows.zip(that.rows).map{r =>
        val pairs = r._1.zip(r._2)
        pairs.map(p => p._1 + p._2)
      }
      ))
    else
      None
  }

  def *(that: Matrix): Option[Matrix] = {
    if ((colNum == that.colNum) && (rowNum == that.rowNum))
      Some(new Matrix(rows.zip(that.rows).map{r =>
        val pairs = r._1.zip(r._2)
        pairs.map(p => p._1 * p._2)
      }
      ))
    else
      None
  }

  def *(scalar: Int): Option[Matrix] = {
    Some(new Matrix(rows.map(_.map(_ * scalar))))
  }

  override def toString: String = rows.map(_.mkString(" ")).mkString("\n")
}

val m1 = new Matrix(Seq(
  Seq(1, 2, 3),
  Seq(4, 5, 6)
))
val m2 = new Matrix(Seq(
  Seq(7, 8, 9),
  Seq(9, 8, 7)
))

m1(1, 2)
m1 * m2
m1 + m2
m2 * 4
