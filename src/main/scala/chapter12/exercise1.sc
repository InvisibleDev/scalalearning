val values = (fun: (Int) => (Int, Int), low: Int, high:Int) => (low to high).map(fun)

values(x => (x, x*x), -5, 5)