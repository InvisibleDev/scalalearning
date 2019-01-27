import scala.annotation.tailrec

trait SumTrait {

  @tailrec
  final def sum(arr: Array[Int], initSum: Int): Int = {
    if (arr.isEmpty)
      initSum
    else {
      sum(arr.tail, arr.head + initSum)
    }
  }
}

class Sum extends SumTrait

val s = new Sum()
s.sum(Array(1,2,3,4,5,6), 0)