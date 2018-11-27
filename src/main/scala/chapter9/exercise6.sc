val pattern = """like this, maybe with \\""".r

for(line <- io.Source.fromFile("c:/temp/hello.txt").getLines()) {
  val matched = pattern.findFirstMatchIn(line)
  if (matched.isDefined)
    println(line)
}
