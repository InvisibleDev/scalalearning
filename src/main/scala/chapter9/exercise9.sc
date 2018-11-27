import java.io.File

def getFilesWithExtension(path:String, extension: String): Int = {
  val dir = new File(path)
  if (dir.isDirectory)
    dir.listFiles().map(f => getFilesWithExtension(f.getAbsolutePath, extension)).sum
  else if (dir.getName.endsWith(extension))
    1
  else
    0
}

getFilesWithExtension("C:\\Users\\Alienware 15\\IdeaProjects\\scalalearning\\target", ".class")