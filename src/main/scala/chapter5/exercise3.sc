class Time (val hours: Int, val minutes: Int){
  def before(other: Time)= hours * minutes < other.hours * minutes
}

val t1 = new Time(12,45)
val t2 = new Time(13, 34)
assert(t1.before(t2), "12:45 < 13:34")
assert(!t1.before(t1), "12:45 is not less itself")
assert(!t2.before(t1), "13:34 can't be less than 12:45")