val numPattern = "[0-9]+".r

for(matchString <- numPattern.findAllIn("99 bottles, 98 bottles"))
  println(matchString) //prints 99 then 98

"98 bottles".matches("[0-9]+ [a-z]+") //returns true
numPattern.replaceAllIn("99 bottles, 98 bottles", "XX")

val numitemPattern = "([0-9]+) ([a-z]+)".r
for (m <- numitemPattern.findAllMatchIn("99 bottles, 98 bottles"))
  println(m.group(1))

//val numitemPattern(num, item) = "99 bottles"
//println(num) // 99
//println(item) // bottles

for (numitemPattern(num, item) <- numitemPattern.findAllMatchIn("99 bottles, 98 bottles"))
  println(s"$num $item")
//import java.io._
//
//import io.Source
//
//val f = Source.fromFile("C:/temp/sharpe.csv")
//for (l <- f.getLines())
//  println(l)
//print(f.reset().mkString.length)
//f.close()
//val url = Source.fromURL("http://www.google.com")
//url.mkString
//url.close()
//
//// Scala doesn't have lib for writing, use Java lib
//val pw = new PrintWriter("c:/temp/hello.txt")
//pw.println("Hello\nGoodBye")
//pw.close()
//
//class Person extends Serializable{
//  val name = "Name"
//  val surname = "Surname"
//}
//val p = new Person()
////serialize object to a file
//val out = new ObjectOutputStream(new FileOutputStream("c:/temp/person"))
//out.writeObject(p)
//out.close()
////reading and deserialization
//val in = new ObjectInputStream(new FileInputStream("c:/temp/person"))
//val sameOldP = in.readObject().asInstanceOf[Person]
