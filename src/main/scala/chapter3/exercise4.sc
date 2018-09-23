def posNegOrder(arr: Array[Int]) = {
  val pos = for(elem <- arr if elem > 0) yield elem
  val neg = for(elem <- arr if elem <= 0) yield elem
  pos ++ neg
}

posNegOrder(Array(1, -3, 4, 0, -9, 10, -98, -10))