package chapter2

import java.time.LocalDate
object DateInterpolator {

  implicit class DateInterpolator(val sc: StringContext) extends AnyVal {
    def date(args: Any*): LocalDate = {
      val dateComponents = for (arg <- args) yield arg.toString.toInt
      println(dateComponents)
      require(dateComponents.length == 3, "Format should be year-month-date")
      require(dateComponents.forall(_.getClass.getName == "int"), "Not all components are integers")
      LocalDate.of(dateComponents(0), dateComponents(1), dateComponents(2))
    }
  }

}