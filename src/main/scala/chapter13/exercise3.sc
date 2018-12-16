import scala.collection.mutable.ListBuffer

val lb = ListBuffer(-10000000 to 10000000)

val now = System.nanoTime()
val copied = lb.zipWithIndex.filter(_._2 % 2 == 0).map(_._1)
val later = System.nanoTime()
println(s"total time ${later - now} ns")

val now1 = System.nanoTime()
for ((_, idx1) <- lb.zipWithIndex) {
  val idx = lb.length - idx1 - 1
  if ((idx % 2 != 0) && (idx >= 0))
    lb.remove(idx)
}
val later1 = System.nanoTime()
println(s"total time ${later1 - now1} ns. ${((later1.toFloat - now1.toFloat)/(later.toFloat - now.toFloat) - 1) * 100}%")