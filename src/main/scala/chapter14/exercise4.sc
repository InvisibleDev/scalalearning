sealed abstract class Item
case class Article(description: String, price: Double) extends Item
case class Bundle(description: String, discount: Double, items: Item*) extends Item {
  def price = {
    items match {
      case i: Seq[Article] => i.map(_.price).sum
      case _ => 0.0
    }
  }
}
case class Multiple(itemsCount: Int, item: Item) extends Item {
  def price: Double = {
    item match {
      case Article(_, price) => itemsCount * price
      case b @ Bundle(_, discount, _) => itemsCount * discount * b.price
      case m @ Multiple(_, _) => itemsCount * m.price
      case _ => 0.0
    }
  }
}

val m = Multiple(10, Article("Blackwell Toaster", 29.95))
m.price
val m1 = Multiple(10, m)
m1.price