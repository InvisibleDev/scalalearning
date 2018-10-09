class Counter {
  private var value = 0L
  def increment = {value += 1}
  def current = value
}

val c = new Counter
for(i <- 0 to Int.MaxValue)
  c.increment
print(c.current)