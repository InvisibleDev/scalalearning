def runInThread(block: => Unit): Unit = {
  new Thread {
    override def run() {block}
  }.start()
}
runInThread{println("Hi"); Thread.sleep(1000); println("Bye")}

def multiOneAtATime(x: Int)(y: Int) = x*y
//multiOneAtATime(3)
multiOneAtATime(3)(4)

val mulOneAtATime = (x: Int) => (y: Int) => x * y
mulOneAtATime(3)
mulOneAtATime(3)(4)

(1 to 9).map("*" * _).foreach(println)

def pow2(x:Double) = x*x
def valueAtOneQuarter(f: (Double) => Double) = f(0.25)
valueAtOneQuarter(pow2)

def triple(x: Double) = x * 3

val tripleMethod = (x:Double) => x *3

println(triple _)
println(tripleMethod)