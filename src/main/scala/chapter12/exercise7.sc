val pairs = (1 to 10) zip (11 to 20)

val adjustToPair = (fun: (Int, Int) => Int) => (pair: (Int, Int)) => fun(pair._1, pair._2)

adjustToPair(_ * _)((6, 7))
pairs.map(adjustToPair(_ + _))