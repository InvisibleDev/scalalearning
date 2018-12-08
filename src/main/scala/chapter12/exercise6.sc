val largestAt = (fun: Int => Int, inputs: Seq[Int]) => inputs.zip(inputs.map(fun)).maxBy(_._2)._1

largestAt(x => 10 * x - x*x, 1 to 10)