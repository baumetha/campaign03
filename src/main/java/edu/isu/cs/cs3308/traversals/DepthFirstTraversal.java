/**
 * @author Ethan Baumgartner
 * Code based off Isaac Griffith psudocode
 */
package edu.isu.cs.cs3308.traversals;

import edu.isu.cs.cs3308.structures.Node;
import edu.isu.cs.cs3308.structures.Tree;
import edu.isu.cs.cs3308.structures.impl.LinkedBinaryTree;

import java.util.LinkedList;
import java.util.List;


public abstract class DepthFirstTraversal<E> extends AbstractTraversal<E> {
    public DepthFirstTraversal(Tree<E> t)throws IllegalArgumentException {
        super((LinkedBinaryTree<E>) t);
        if (tree == null) throw new IllegalArgumentException();
    }

    public Iterable<Node<E>> traverse() {
        return traverseFrom(tree.root());
    }
    public Iterable<Node<E>> traverseFrom(Node node) {
        return subTreeTraverse(node);
    }

    public List<Node<E>> subTreeTraverse(Node<E> node)throws IllegalArgumentException {
        LinkedList<Node<E>> list = new LinkedList<>();
        if (!tree.isEmpty()) {
            subtree(node, list);
        }
        return list;
    }

    public void subtree(Node<E> node, List<Node<E>> list) {
    }
}