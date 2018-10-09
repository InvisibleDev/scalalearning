class Time (val hours: Int, val minutes: Int){
  require((hours >= 0) && (hours < 24), "Hours can be within 0..23 range")
  require((minutes >= 0) && (hours < 60), "Minutes can be within 0..59 range")
  def before(other: Time)= hours * minutes < other.hours * minutes
}

val t1 = new Time(12,45)
val t2 = new Time(13, 34)
assert(t1.before(t2), "12:45 < 13:34")
assert(!t1.before(t1), "12:45 is not less itself")
assert(!t2.before(t1), "13:34 can't be less than 12:45")

class ParentClass {
  val parentAttr = 0

  class NestedClass{
    val nesterAttr = 6
  }
}
var inst1 = new ParentClass
var inst2 = new inst1.NestedClass