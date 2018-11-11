class BankAccount(initialBalance: Double) {
  private var balance = initialBalance
  def currentBalance = balance
  def deposit(amount: Double) = {
    balance += amount
    balance
  }
  def withdraw(amount: Double) = {
    balance -= amount
    balance
  }
}

class CheckingAccount(initialBalance: Double) extends BankAccount(initialBalance) {
  private val operationFee = 1
  private def chargeOperationFee: Unit =
    print(s"Charged $operationFee for an operation on account. Remaining balance is ${super.withdraw(operationFee)}")

  override def deposit(amount: Double): Double = {
    chargeOperationFee
    super.deposit(amount)
  }

  override def withdraw(amount: Double): Double = {
    chargeOperationFee
    super.withdraw(amount)
  }
}

val initialBalance = 100
val acc = new CheckingAccount(initialBalance)
acc.withdraw(10)
acc.deposit(10)
assert(acc.currentBalance == initialBalance - 2)