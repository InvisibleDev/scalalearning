import java.util.concurrent.Executors
import scala.concurrent._
import scala.concurrent.duration._
import scala.util.{Failure, Success, Try}

val pool = Executors.newCachedThreadPool()
implicit val ec = ExecutionContext.fromExecutor(pool)

val f = Future{
  Thread.sleep(1000)
  throw new Exception("Example exception")
}
Await.ready(f, 2.seconds)
val Some(t) = f.value
t match {
  case Success(v) => v
  case Failure(ex) => ex.getMessage
}

if (t.isFailure)
  t.failed.get.getMessage
else if (t.isSuccess)
  t.get

val result = Try(1/0)
if (result.isFailure)
  result.failed.get.getMessage
f.onComplete{
  case Failure(exception) => exception.getMessage
  case Success(value) => value
}

def f1 = Future(2+3)
def f2 = Future(3+4)

val res = f1.flatMap(v1 => f2.map(v1 + _))
var res1 = for (v1 <- f1; v2 <- f2 if v1 == v2) yield v1 + v2

val recovered = Future(1 / 0) recover {case _: ArithmeticException => 0}
recovered

Future(1 / 0) fallbackTo Future(0)

val zipRes = Future(2).zipWith(Future(3))(_ + _)
Thread.sleep(100)
zipRes

val parts = Seq(1,2,3,4,5,6,7,8)
val futures = parts.map(v => Future(math.pow(v, v)))
val results = Future.sequence(futures)
val futRes = Future.traverse(parts)(p => Future(math.pow(p, p)))
Await.ready(futRes, 10.seconds)

val first = Future.firstCompletedOf(futures)

val p = Promise[Double]
Future{
  p.trySuccess(math.pow(10, 10))
  p.trySuccess(math.sqrt(math.pow(10, 10)))
  p.trySuccess(math.pow(5, 5))
  p.trySuccess(math.sqrt(math.pow(5, 5)))
}
if (p.isCompleted)
  p.future.value.get.get

Future{
  math.exp(20)
  blocking {
    Thread.sleep(10000)
  }
}