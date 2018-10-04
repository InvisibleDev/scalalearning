def lteqgt(values: Array[Int], v:Int)=
  (values.count(x => x < v),
    values.count(x => x == v),
    values.count(x=> x > v))

println(lteqgt(Array(1,2,3,4,4,5,5,4,6,7), 4))
