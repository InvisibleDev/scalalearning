import scala.collection.mutable.ArrayBuffer
class Network {
  class Member(val name: String) {
    val contacts = new ArrayBuffer[Network#Member]()

    override def toString: String = {
      var contactsStr = ""
      for(c <- contacts)
        contactsStr += (c.name + ", ")
      contactsStr
    }
  }
  private val members = new ArrayBuffer[Member]()

  def join(name: String): Member = {
    val m = new Member(name)
    members += m
    m
  }
}

val chatter = new Network
val myFace = new Network
val fred = chatter.join("Fred")
val wilma = chatter.join("Wilma")
fred.contacts += wilma
val barney = myFace.join("Barney")
fred.contacts += barney
println(fred)
