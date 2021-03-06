/**
 * @author Ethan Baumgartner
 * Code based off Isaac Griffith psudocode
 */
package edu.isu.cs.cs3308.traversals;

import edu.isu.cs.cs3308.structures.Node;

import edu.isu.cs.cs3308.structures.Tree;


import java.util.List;


public class PostOrderTraversal<E> extends DepthFirstTraversal<E> {
    public PostOrderTraversal(Tree<E> t) {
        super(t);
    }
    public void subtree(Node<E> node, List<Node<E>> list) {
        if (node == null || list == null)
            throw new IllegalArgumentException();
        if (tree.left(node) != null) {
            subtree(tree.left(node), list);
        }
        if (tree.right(node) != null) {
            subtree(tree.right(node), list);
        }
        list.add(node);
    }
}