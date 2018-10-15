import java.util.{HashMap => JavaHashMap}

val javaMap = new JavaHashMap[Int, String]()
javaMap.put(1, "one")
javaMap.put(2, "two")

def copyToScalaMap(m: JavaHashMap[Int, String]) = {
  import scala.collection.mutable.HashMap
  val scalaMap = new HashMap[Int, String]
  m.forEach((k:Int, v: String) => scalaMap.put(k, v))
  scalaMap.foreach(p => println(p._1 + " : " + p._2))
}

copyToScalaMap(javaMap)