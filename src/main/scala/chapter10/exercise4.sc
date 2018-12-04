trait CryptoLogger {
  val caesarKey: Int
  val letterToNumber = 'a'.to('z').zipWithIndex.toMap
  val numberToLetter = letterToNumber.map(t => t._2 -> t._1)

  def log(msg: String) = println(encrypt(msg))

  def encrypt(msg: String) =
    msg.map(c => numberToLetter.get(letterToNumber.get(c).map(caesarCypher).get).get)

  private def caesarCypher(charPlace: Int) = (charPlace + caesarKey) % 26
  private def caesarDecypher(charPlace: Int) = (charPlace - caesarKey) % 26

  def decrypt(msg: String) =
    msg.map(c => numberToLetter.get(letterToNumber.get(c).map(caesarDecypher).get).get)
}

class CryptoLoggerInstance(key: Int = 3) extends CryptoLogger{
  override lazy val caesarKey: Int = key
}

val c3 = new CryptoLoggerInstance()
c3.log("hello")

val c0 = new CryptoLoggerInstance(0)
c0.log("hello")

val cMinus3 = new CryptoLoggerInstance(-3)
cMinus3.log("hello")