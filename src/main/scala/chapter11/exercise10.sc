import java.nio.file.Paths

object PathComponents {
  def unapplySeq(arg: java.nio.file.Path): Option[Seq[String]] =
    Some(
      Seq(
        arg.getRoot.toString,
        arg.getParent.toString,
        arg.getFileName.toString
      )
    )
}

val path = Paths.get("c:/temp/sharpe.csv")
path match {
  case PathComponents(root, parent, filename) =>
    println(s"""
    root=$root
    parent=$parent
    filename=$filename""")
  case _ =>
    None
}