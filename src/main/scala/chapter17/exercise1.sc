import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

val f1 = Future {Thread.sleep(1000) ; 2}
val f2 = Future {Thread.sleep(1000); 40}

for (n1 <- f1; n2 <- f2)
  println(n1 + n2)
val res = f1.flatMap(r => f2.map(r2 => println(r2 + r)))
Thread.sleep(2500)
