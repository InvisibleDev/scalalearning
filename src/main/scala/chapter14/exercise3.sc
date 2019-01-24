def swap(arr: Array[Any]) =
arr match {
  case a1 @ Array(_, _) => Array(a1(1), a1(0))
  case a2 @ Array(_, _, rest @ _*) => Array(a2(1), a2(0)) :+ rest
  case _ => arr
}

swap(Array(1,2,3, 4,5))
swap(Array(1))