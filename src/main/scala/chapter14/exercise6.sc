sealed abstract class BinaryTree
case class Leaf(value: Int) extends BinaryTree
case class Node(left: BinaryTree, right: BinaryTree) extends BinaryTree

def leafSum(tree: BinaryTree): Int = {
  tree match {
    case Leaf(value) => value
    case Node(left, right) => leafSum(left) + leafSum(right)
    case _ => 0
  }
}
leafSum(Node(Node(Leaf(3), Leaf(4)), Leaf(5)))