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

class SavingsAccount(initialBalance: Double) extends BankAccount(initialBalance){
  private val monthlyInterest = 0.05
  private var remainingDeposits = 3
  def earnMonthlyInterest = {
    remainingDeposits = 3
    deposit(currentBalance * monthlyInterest)
  }

  override def deposit(amount: Double): Double = {
    if (remainingDeposits >= 0) {
      remainingDeposits -= 1
      super.deposit(amount)
    }
    else
      throw new IllegalAccessException(s"Can't deposit more than $remainingDeposits times per month")
  }
}

val a = new SavingsAccount(100)
a.earnMonthlyInterest
for(_ <- 0 to 3) {
  try
    a.deposit(100)
  catch {
    case _ => println("Chill, exception is caught.")
  }
}
a.currentBalance
