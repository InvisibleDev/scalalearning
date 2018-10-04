import scala.collection.JavaConverters._

val allProps = System.getProperties.asScala
val longestProperty = allProps.keys.reduce((x1, x2) => if (x1.length < x2.length) x2 else x1)

allProps.foreach(
  p => println(p._1 + " " * (longestProperty.length - p._1.length + 1) + "| " +p._2)
)