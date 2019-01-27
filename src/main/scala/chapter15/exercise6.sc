@volatile var flag = false

class FlagSetter extends Runnable{
  def run() = {
    Thread.sleep(10)
    flag = true
  }
}

class FlagChecker extends Runnable{
  def run() = {
    while (!flag) {
      Thread.sleep(1)
      println(s"Flag is still $flag")
    }
    println(s"Flag is $flag")
  }
}

val thread1 = new Thread(new FlagSetter()).start()
val thread2 = new Thread(new FlagChecker()).start()