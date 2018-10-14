package chapter6

class Account private (val id: Int, initialBalance: Double) {
  val balance = initialBalance
}
object Account {
  private var uniqueNumber = 0
  def newUniqueNumber() = {
    uniqueNumber += 1
    uniqueNumber
  }
  def apply(initialBalance: Double): Account =
    new Account(newUniqueNumber(), initialBalance)
}