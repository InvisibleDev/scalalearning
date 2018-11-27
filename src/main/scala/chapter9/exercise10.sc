import java.io.{FileInputStream, FileOutputStream, ObjectInputStream, ObjectOutputStream}

case class Person(val name: String, val friends: Array[Person]) extends Serializable{
}

val FilePath = "c:/temp/people"
val rustam = new Person("Rustam", Array.empty)
val olena = new Person("Olena", Array(rustam))
val ray = new Person("Ray", Array(rustam, olena))

val people = Array(rustam, olena, ray)
val out = new ObjectOutputStream(new FileOutputStream(FilePath))
out.writeObject(people)
out.close()

val in = new ObjectInputStream(new FileInputStream(FilePath))
val people2 = in.readObject().asInstanceOf[Array[Person]]

require(people.map(_.name).mkString(" ") == people2.map(_.name).mkString(" "))
require(people.flatMap(_.friends.map(_.name)).mkString(" ") == people2.flatMap(_.friends.map(_.name)).mkString(" "))
