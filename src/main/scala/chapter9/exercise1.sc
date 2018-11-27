import java.io.PrintWriter

def reverseLinesInFile(inFilepath: String, outFilePath: String): Unit = {
  val inFile = io.Source.fromFile(inFilepath)
  val outFile = new PrintWriter(outFilePath)
  for (line <- inFile.getLines().toList.reverse)
    outFile.println(line)
  inFile.close()
  outFile.close()
}

reverseLinesInFile("c:/temp/sharpe.csv", "c:/temp/sharpe_reversed.csv")