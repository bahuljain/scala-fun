package leetcode

import s99.{ Tree, Node, End }

object CommonAncestorBST extends App {
	def commonAncestor[T](root: Tree[T], p: Tree[T], q: Tree[T])(implicit ord: Ordering[T]): Tree[T] = (p, q) match {
		case (Node(vp, _, _), Node(vq, _, _)) =>
			if (ord.gt(vp, vq)) commonAncestor(root, q, p)
			else root match {
				case Node(vr, lr, rr) =>
					if (ord.gteq(vr, vp) && ord.lteq(vr, vq)) root
					else if (ord.gt(vr, vq)) commonAncestor(lr, p, q)
					else commonAncestor(rr, p, q)
				case _ => throw new NoSuchElementException
			}
		case _ => throw new IllegalArgumentException
	}

	val tree = Node(4, Node(2, Node(1), Node(3)), Node(6, Node(5), Node(7)))

	println(commonAncestor(tree, Node(1), Node(3)))
}