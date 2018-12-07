class DynamicProps(val props: java.util.Properties) extends Dynamic {
  def updateDynamic(name: String)(value: String): Unit = {
    props.setProperty(name.replaceAll("_", "."), value)
  }

  def selectDynamic(name: String)=
    props.getProperty(name.replaceAll("_", "."))

  def applyDynamicNamed(name: String)(args: (String, String)*): Unit = {
    for((k, v) <- args)
      props.setProperty(k.replaceAll("_", "."), v)
  }
}

//TODO needs completion