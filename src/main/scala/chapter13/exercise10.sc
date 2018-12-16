java.util.TimeZone.getAvailableIDs
  .groupBy(_.split('/')(0))
  .map(p => p._1 -> p._2.length)
  .maxBy(_._2)