package chapter15

class Exercise6{

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
        Thread.sleep(2)
      }
      println(s"Flag is $flag")
    }
  }

  def main(args: Array[String]): Unit = {
    val thread1 = new Thread(new FlagSetter()).start()
    val thread2 = new Thread(new FlagChecker).start()
  }
}
