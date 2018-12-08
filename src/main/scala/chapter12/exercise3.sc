val factorial = (x: Int) => 1.to(x).reduceLeft(_ * _)

factorial(16)