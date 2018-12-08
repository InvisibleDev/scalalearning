val a = Array("Hello", "new", "scala", "world")
val b = Array(5, 3, 5, 5)

a.corresponds(b)(_.length == _)