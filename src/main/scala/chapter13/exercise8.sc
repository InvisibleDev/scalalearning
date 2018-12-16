def arrTo2Dim(arr: Array[Double], numOfColumns: Int) =
  arr.grouped(numOfColumns).toArray

arrTo2Dim(Array(1, 2, 3, 4, 5, 6), 3)