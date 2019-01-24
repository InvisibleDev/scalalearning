sealed abstract class Tree
case class Leaf(value: Int) extends Tree
case class Node(trees: Tree*) extends Tree

def leafSum(tree: Tree): Int = {
  tree match {
    case Leaf(value) => value
    case Node(trees @ _*) => trees.map(leafSum).sum
    case _ => 0
  }
}
leafSum(Node(Node(Leaf(3), Leaf(8)), Leaf(2), Node(Leaf(5))))