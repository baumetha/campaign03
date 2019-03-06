/**
 * @author Ethan Baumgartner
 * Code based off Isaac Griffith psudocode
 */
package edu.isu.cs.cs3308.traversals;

import edu.isu.cs.cs3308.structures.Node;
import edu.isu.cs.cs3308.structures.Tree;
import edu.isu.cs.cs3308.structures.impl.LinkedBinaryTree;

import edu.isu.cs.cs3308.structures.impl.LinkedQueue;

import java.util.LinkedList;


public class BreadthFirstTraversal<E> extends AbstractTraversal<E> {
    public BreadthFirstTraversal(Tree<E> t) {
        super((LinkedBinaryTree<E>) t);
    }
    public Iterable<Node<E>> traverse(){
        if (tree == null || tree.isEmpty())
            return new LinkedList<>();
        else
            return traverseFrom(tree.root());
    }
    public Iterable<Node<E>> traverseFrom(Node node){
        if (node == null)
            throw new IllegalArgumentException();
        LinkedQueue<Node<E>> queue = new LinkedQueue<>();
        LinkedList<Node<E>> list = new LinkedList<>();
        while (!queue.isEmpty()){ queue.poll();
            node = queue.poll();
            list.add(node);
            if (tree.left(node) != null){
                queue.offer(tree.left(node));
            }
            if (tree.right(node) != null){
                queue.offer(tree.right(node));
            }
        }
        return list;
    }

}