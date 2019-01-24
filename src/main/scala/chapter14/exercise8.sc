sealed abstract class Tree {
  def eval: Double
}
case class Leaf(value: Int) extends Tree {
  def eval: Double = value.toDouble
}
case class Node(op: Char, nodes: Tree*) extends Tree {
  def eval: Double = {
    op match {
      case '+' => nodes.map(_.eval).sum
      case '-' =>
        val nodeValues = nodes.map(_.eval)
        if (nodeValues.length == 1)
          -nodeValues(0)
        else
          nodeValues.reduce(_ - _)
      case '*' => nodes.map(_.eval).reduce(_ * _)
      case ':' => nodes.map(_.eval).reduce(_ / _)
      case _ => 0.0
    }
  }
}

val tree = Node('+',Node('*', Leaf(3), Leaf(8)), Leaf(2), Node('-', Leaf(5)))
tree.eval