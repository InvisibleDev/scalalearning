object Name {
  def unapplySeq(input: String): Option[Seq[String]] =
    if(input.trim.isEmpty) None else Some(input.trim.split("\\s+"))
}

Name("Olena Pavolotska") match {
  case (first, last) => println(s"$first $last")
  case (first) => println(first)
}