class BankAccount {
  private var accountBalance = 0L
  def deposit(amount: Int) = accountBalance += amount
  def withdraw(amount: Int) = accountBalance -= amount

  def balance = accountBalance
}

val acc = new BankAccount

acc.deposit(300)
acc.deposit(300)
acc.withdraw(200)
acc.balance