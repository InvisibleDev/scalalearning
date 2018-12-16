def indexes(w: String) =
  w.zipWithIndex
    .groupBy(_._1)
      .map(p => (p._1, p._2.map(p => p._2).toList))

indexes("Mississippi")