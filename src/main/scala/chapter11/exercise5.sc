class Table(val rows: Seq[Seq[String]]) {
  def |(t: String) =
    new Table(rows.dropRight(1) :+ (rows.lastOption.getOrElse(Seq.empty) :+ t))

  def ||(t: String) =
    new Table(rows :+ Seq(t))

  override def toString: String =
    rows.map(r => r.mkString("<td>", "</td><td>", "</td>"))
      .mkString("<table><tr>", "</tr><tr>", "</tr></table>")
}

object Table {
  def apply(rows: Seq[Seq[String]] = Seq.empty): Table = new Table(rows)
}

Table() | "Java" | "Scala" || "Gosling" || "Odersky" || "JVM" || "JVM, .NET"
