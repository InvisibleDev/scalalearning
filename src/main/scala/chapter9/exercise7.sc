val f = io.Source.fromFile("c:/temp/sharpe_tabbed.csv")
val pattern = "[+-]*[0-9]+[.][0-9]*"

for (line <- f.getLines())
  line.split(" ").filter(!_.matches(pattern)).map(println)