val largest = (fun: Int => Int, inputs: Seq[Int]) => inputs.map(fun).reduce(math.max(_, _))

largest(x => 10 * x - x*x, 1 to 10)