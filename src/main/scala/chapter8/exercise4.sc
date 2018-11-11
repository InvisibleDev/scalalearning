abstract class Item {
  def price: Double
  def description: String
}

class SimpleItem(val price: Double, val description: String) extends Item

class Bundle(items: SimpleItem*) extends Item{
  private var currentItems = items.toSeq
  override def price: Double = items.map(_.price).reduce(_ + _)

  override def description: String = "Bundle of:\n" + items.map(_.description).mkString("\n")

  def add(items: SimpleItem*) = {
    currentItems = currentItems ++ items
  }
}

val b = new Bundle(new SimpleItem(10, "pen"),
  new SimpleItem(20, "notebook"),
  new SimpleItem(20, "book")
)
b.price
println(b.description)