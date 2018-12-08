val factorial = (x: Int) => 1.to(x).foldLeft(1)(_ * _)

(-10).to(10).foreach(x => println(s"factorial($x) = ${factorial(x)}"))