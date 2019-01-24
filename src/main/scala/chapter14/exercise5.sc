def leafSum(l: List[Any]): Int = {
  if (l.isEmpty)
    0
  else {
    val sum = l.head match {
      case number: Int => number
      case list: List[Any] => leafSum(list)
    }
    sum + leafSum(l.tail)
  }
}

leafSum(List(1, 2, List(3, 5)))