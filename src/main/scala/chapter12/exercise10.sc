def unless(cond: Boolean)(b: => Unit) = if (!cond) b else None

val name = "rustam"
unless(name.isEmpty)(println(s"Hello $name"))

unless(true)(println("Wouldn't print me"))