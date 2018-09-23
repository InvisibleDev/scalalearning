def swapAdjacent(arr: Array[Int]) = {
  for (i <- 0 until arr.length - 1 by 2; temp = arr(i)){
    arr(i) = arr(i + 1)
    arr(i + 1) = temp
  }
  arr
}

swapAdjacent(Array(1,2,3,4,5))