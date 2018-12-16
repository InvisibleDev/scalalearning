val strings = Array("Tom", "Fred", "Harry")
val stringsToNumbers = Map("Tom" -> 3, "Dick" -> 4, "Harry" -> 5)

def function(strings: Array[String], stringsToNumbers: Map[String, Int]) =
  strings.flatMap(stringsToNumbers.get)

function(strings, stringsToNumbers)