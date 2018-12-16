def mkStringWithReduceLeft(strings: Iterable[String], sep: String) =
  strings.reduceLeft(_ + sep + _)

val sep = ", "
val strings = Array("Tom", "Fred", "Harry")
require(mkStringWithReduceLeft(strings, sep) == strings.mkString(sep))
