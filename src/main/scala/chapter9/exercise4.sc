val numbers = io.Source.fromFile("c:/temp/numbers.csv").getLines.map(_.toDouble).toList
println(s"""sum=${numbers.sum}
           average=${numbers.sum/numbers.length}
           maximum=${numbers.max}
           minimum=${numbers.min}
""")