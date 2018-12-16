import scala.collection.mutable.{Map, SortedSet}

def indexes(w: String) =
  Map(w.zipWithIndex
    .groupBy(_._1)
      .map(p => (p._1, SortedSet(p._2.map(p => p._2): _*)))
        .toSeq: _*)

indexes("Mississippi")