def sum(l: List[Option[Int]]) = l.map(_.getOrElse(0)).sum

sum(List(Some(3), None, Some(9)))