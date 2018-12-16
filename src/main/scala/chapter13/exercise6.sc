val lst = 1 to 5
(lst :\ List[Int]())(_ :: _)
(List[Int]() /: lst)(_ :+ _)
//reversed
(List[Int]() /: lst)((l, number) => number :: l)