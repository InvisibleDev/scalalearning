for (i <- (0 until 10000).par) print(s" $i")

val palindromSquares = (1 to 10000).view
  .map(x => x * x)
  .filter(x => x.toString == x.toString.reverse)
palindromSquares.take(10).mkString(", ")
palindromSquares.take(10).mkString(", ")

def counter(n: Int): Stream[Int] = n #:: counter(n+1)

val s = counter(0)
s.tail
s.tail.tail
s

Seq(1, 2, 3, 4, 5, 6).toStream

Seq(1,2,3) zip Seq("a", "b") // List((1,a), (2,b))
Seq(1,2).zipAll(Seq("a", "b", "c"), None, "c") // List((1,a), (2,b), (3,c))

(0 /: Seq(1, 2, 3, 4, 5, 6))(_ - _) //-21
(Seq(1, 2, 3, 4, 5, 6) :\ 0)(_ - _) //-3
Seq(1, 2, 3, 4, 5, 6).scanLeft(0)(_ - _)

Seq(0, 1, 3, 4, 5, 6).foldLeft(0)(_ + _) // -19

Seq(1, 2, 3, 4, 5, 6).reduceRight(_ - _) // -9

Seq(1, 2, 3, 4, 5, 6).reduceLeft(_ - _) // -9

Seq(1, 2, 3, 4, 5, 6).collect{case a: Int => a*2}

Seq(1, 2, 3, 4, 5, 6).padTo(10, 0)

Seq(1, 2, 3, 4, 5, 6).groupBy(_ % 2)

Seq(1, 2, 3, 4, 5, 6).grouped(2).toList

Seq(1, 2, 3, 4, 5, 6).slice(2, 6)
Seq(1, 2, 3, 4, 5, 6).view(2, 6)

Seq(1, 2, 3, 4, 5, 6).takeRight(2)
Seq(1, 2, 3, 4, 5, 6).dropRight(2)

Seq(1, 2, 3, 4, 5, 6).take(2)
Seq(1, 2, 3, 4, 5, 6).drop(2)
Seq(1, 2, 3, 4, 5, 6).splitAt(3)

Seq(1,2,3,0, 1,2,3).dropWhile(_<2)
Seq(1,2,3,0, 1,2,3).takeWhile(_>0)
Seq(1,2,3,0, 1,2,3).span(_>0)

Seq(1,2,3) :+ 4
0 +: Seq(1,2,3)
Set(1,2,3) + 4
Set(1,2,3) + (3,4,5)
Set(1,2,3) - 3
Set(1,2,3) - (1,2)
Set(1,2,3) ++ Seq(4,5,6)
List(1,2,3) ::: List(4,5,6)

Seq(1,2,3).sameElements(Set(1,2,3))