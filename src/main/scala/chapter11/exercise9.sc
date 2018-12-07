import java.nio.file.Paths

object PathComponents {
  def unapply(arg: java.nio.file.Path): Option[(String, String)] =
    Some((arg.getParent.toString, arg.getFileName.toString))
}

val PathComponents(parentDir, filename) = Paths.get("c:/temp/sharpe.csv")
println(s"parentDirectory=$parentDir; filename=$filename")