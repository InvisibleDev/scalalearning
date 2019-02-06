import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

def doInOrder[T, U, V](f: T => Future[U], g: U => Future[V]): T => Future[V] = {
  (x: T) => f(x).flatMap(g(_))
}

def f(x: Int) = Future(x / 100.0)
def g(y: Double) = Future(s"Result is $y")

var fut = doInOrder(f, g)(1)

fut.value match {
  case Some(Success(value)) => value
  case Some(Failure(exception)) => exception.getMessage
}

