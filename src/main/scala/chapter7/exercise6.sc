import java.util.{HashMap => JavaHashMap}

import scala.collection.mutable.HashMap

val javaMap = new JavaHashMap[Int, String]()
javaMap.put(1, "one")
javaMap.put(2, "two")

val scalaMap = new HashMap[Int, String]
javaMap.forEach((k, v) => scalaMap.put(k, v))
scalaMap.foreach(p => println(p._1 + " : " + p._2))
