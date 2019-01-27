import java.io.File

def getFileContent(filePath: String) = {
  io.Source.fromFile(new File(filePath)).mkString
}

getFileContent("c:/temp/hello.txt")