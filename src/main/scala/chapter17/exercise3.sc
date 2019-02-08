import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

def funcsInOrder[T](futureFuncs: (T => Future[T])*): T => Future[T] = {
  if (futureFuncs.length == 1)
    (t: T) => futureFuncs.head(t)
  else
    (t: T) => futureFuncs.head(t).flatMap(r => funcsInOrder[T](futureFuncs.tail: _*)(r))
}

val f1 = (t:Int) => Future(t * t)
val f2 = (t: Int) => Future(t + t)
val f3 = (t:Int) => Future(t * 8)

val res = funcsInOrder(f1, f2, f3)(4)
Thread.sleep(100)
res