import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.util.{Failure, Success}

def doTogether[T, U, V](f: T => Future[U], g: U => Future[V]): T => Future[(U, V)] = {
  (t: T) => f(t).zip(f(t).flatMap(g(_)))
}

val f = (t: Int) => Future(s"${t.toString}00")
val g = (s: String) => Future(math.sqrt(s.toDouble))

val futRes = Await.ready(doTogether(f, g)(4), 2.seconds)
val Some(res) = futRes.value
res match {
  case Success(v) => v
  case Failure(ex) => ex.getMessage
}