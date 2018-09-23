import scala.collection.mutable.ArrayBuffer

def removeAllButFirstNeg(a: ArrayBuffer[Int]) = {
  val negIndices = for(i <- a.indices if a(i) < 0) yield i
  for(i <- negIndices.tail.reverse)
    a.remove(i)
  a
}

removeAllButFirstNeg(ArrayBuffer(1, -3, 4, 0, -9, 10, -98, -10))