import java.io.File
import java.util
import java.util.Scanner

val in = new Scanner(new File("C:\\Users\\Alienware 15\\IdeaProjects\\scalalearning\\src\\main\\scala\\chapter4\\exercise2.txt"))
var wordCount = new util.TreeMap[String, Integer]()
while (in.hasNext()){
  val word = in.next().toLowerCase.replaceAll("""[\p{Punct}]""", "")
  val count: Int = wordCount.putIfAbsent(word, 1)
  wordCount.put(word, count + 1)
}

println(wordCount)