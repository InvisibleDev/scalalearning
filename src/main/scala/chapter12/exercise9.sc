val a = Array("Hello", "new", "scala", "world")
val b = Array(5, 3, 5, 5)

def corresponds(seq1: Array[String], seq2: Array[Int], fun: (String, Int) => Boolean)=
  seq1.zip(seq2).forall(p => fun(p._1, p._2))

corresponds(a, b, (w: String, n: Int) => w.length == n)