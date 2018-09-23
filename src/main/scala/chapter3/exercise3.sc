def swapAdjacentYield(arr: Array[Int]) =
  for (i <- arr.indices.toArray; len = arr.length)
    yield
      if ((i % 2 == 0) && (i+1 < len))
        arr(i+1)
      else if (i == len-1)
        arr(i)
      else
        arr(i-1)

swapAdjacentYield(Array(1,2,3,4,5))