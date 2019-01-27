import scala.annotation.Annotation
import scala.beans.BeanProperty

class Credentials {
  @BeanProperty val username : String = "username"
  @BeanProperty val password : String = "pwd"
}

val c = new Credentials()
c.getUsername

class Annot extends Annotation
// typed annotation must extend TypeAnnotation