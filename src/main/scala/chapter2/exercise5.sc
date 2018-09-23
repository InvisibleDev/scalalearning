def countdown(n: Int): Unit ={
  for(i <- n to 0 by -1)
    print(i + " ")
}

countdown(6)