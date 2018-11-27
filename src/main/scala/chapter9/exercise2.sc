import java.io.PrintWriter

def replaceTabWithSpace(inFilePath:String): Unit = {
  val lines = io.Source.fromFile(inFilePath).getLines().toList
  val pw = new PrintWriter(inFilePath)
  lines.foreach(l => pw.println(l.replaceAll("""\t""", " ")))
  pw.close()
}

replaceTabWithSpace("c:/temp/sharpe_tabbed.csv")