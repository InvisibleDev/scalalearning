val ch = '8'
ch match {
  case _ if Character.isDigit(ch) =>
    println(s"$ch is digit")
  case '+' => print(1)
  case '-' => print(-1)
  case _ => print(0)
}

ch match {
  case c: Char => println(s"$c is Char")
  case _ => println("Neither Char nor Int")
}

val m = Map(1 -> "1", 2 -> "2")

m match {
  case m1: Map[Int, String] => println("matched")
  case m2: Map[_, _] => println("matched to generic")
  case _ => println("whatever")
}

val arr = Array(0,1,2,3,4,5)
arr match {
  case Array(0, rest @ _*) => println(rest.max)
  case _ => println(0)
}

val Array(x, y, rest @ _*) = Array(1,2,3,4,5,6,7)
println(s"x=$x y=$y and the rest is $rest")

val 1 = x

sealed abstract class Amount
case class Dollar(value: Double) extends Amount
case class Currency(value: Double, unit: String) extends Amount
case object Nothing extends Amount

val amt = Option(Dollar(30))

amt match {
  case Some(Dollar(v)) => println(s"I have $v dollars")
  case _ => println("")
}
case class Wallet(ccy1: Currency, ccy2: Currency)

val wallet = Wallet(Currency(100, "EUR"), Currency(100, "YEN"))
wallet match {
  case Wallet(c1 @ Currency(_, "EUR"), c2 @ Currency(_, _)) => println(c1.value + c2.value)
  case _ => print("")
}

val opt = Some(10)
for (v <- opt)
  println(v)

val f: PartialFunction[Char, Int] = {case '+' => 1; case '-' => 0}
println(f('+'))
println(f.isDefinedAt(0))