class ASCIIArt(val rows: Seq[Array[Char]]) {
  def this(ascii: String) = this(ascii.split("\n").map(_.toCharArray))

  def +(that: ASCIIArt): ASCIIArt = {
    val longestLineThis = rows.map(_.length).max // reduce((r1, r2) => math.max(r1.length, r2.length))
    val longestLineThat = that.rows.map(_.length).max // rows.reduce((r1, r2) => math.max(r1.length, r2.length))
    val rowsDiff = that.rows.length - rows.length
    val rowsExtended = if (rowsDiff > 0) rows ++ Seq.fill(rowsDiff)((" " * longestLineThis).toCharArray) else rows
    new ASCIIArt(
      rowsExtended.zipWithIndex.map(
        r => (r._1 :+ ' ') ++ that.rows.lift(r._2).getOrElse((" " * longestLineThat).toCharArray)
      )
    )
  }

  def |(that: ASCIIArt) = new ASCIIArt(rows ++ Seq.empty ++ that.rows)
  override def toString: String = rows.map(_.mkString("")).mkString("\n")
}

val cat = new ASCIIArt(
  """
    # /\_/\
    #( ' ' )
    #(  -  )
    # | | |
    #(__|__)
  """.stripMargin('#')
)

val catText = new ASCIIArt(
  """
    #   -----
    # / Hello \
    #<  Scala |
    # \ Coder /
    #   -----
  """.stripMargin('#')
)

val catVerticalText = new ASCIIArt(
  """
    #   --^^--
    # |  I am  |
    # | pooing |
    #   ------
  """.stripMargin('#')
)

println(cat + catText)
println(cat | catVerticalText)