import java.util.Calendar

import scala.collection.mutable

val weekdays: mutable.LinkedHashMap[String, Int] = mutable.LinkedHashMap(
  "Monday" -> Calendar.MONDAY,
  "Tuesday" -> Calendar.TUESDAY,
  "Wednesday" -> Calendar.WEDNESDAY,
  "Thursday" -> Calendar.THURSDAY,
  "Friday" -> Calendar.FRIDAY,
  "Saturday" -> Calendar.SATURDAY,
  "Sunday" -> Calendar.SUNDAY
)
//will print in the insertion order
weekdays.foreach(println(_))
weekdays.get("Friday")
