import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.util.{Failure, Success}

def futSequence(futures: Seq[Future[Any]]) = {
  Future.sequence(futures)
}

val futRes = futSequence(Seq(
  Future(2), Future(math.pow(2, 20)), Future("hello World")
))
val Some(res) = Await.ready(futRes, 1.seconds).value
res match {
  case Success(value) => value
  case Failure(exception) => exception.getMessage
}