def swap(pair: (Int, Int)) = {
  val (x, y) = pair
  (y, x)
}

val (four, three) = swap((3,4))
println(s"$four and $three")