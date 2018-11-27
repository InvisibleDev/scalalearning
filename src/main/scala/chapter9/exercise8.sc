val source = io.Source.fromURL("https://en.wikipedia.org/wiki/Art", "UTF-8")
val pattern = """<img .* src="(.*)" />""".r

for(line <- source.getLines();
    matched <- pattern.findAllMatchIn(line))
  println(matched.group(1))
source.close()