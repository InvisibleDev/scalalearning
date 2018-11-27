import java.io.PrintWriter

val pw = new PrintWriter("c:/temp/powers_reciprocals_2.txt")
val powers = 0.to(20).map(math.pow(2, _)).toList
val longest = powers.reduce((x1, x2) => if (x1.toString.length > x2.toString.length) x1 else x2).toString.length
for (power <- powers)
  pw.println(s"$power${" " * (longest - power.toString.length)} ${1 / power}")
pw.close()