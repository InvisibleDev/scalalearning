import java.io.File
import java.util.Scanner

import scala.collection.SortedMap

val in = new Scanner(new File("/home/rustam/IdeaProjects/scalalearning/src/main/scala/chapter4/exercise2.txt"))
var wordCount = SortedMap [String, Int]()
while (in.hasNext()){
  val word = in.next().toLowerCase.replaceAll("""[\p{Punct}]""", "")
  wordCount = if (wordCount.contains(word))
    wordCount + (word -> (wordCount(word) + 1))
  else
    wordCount + (word -> 1)
}

println(wordCount)