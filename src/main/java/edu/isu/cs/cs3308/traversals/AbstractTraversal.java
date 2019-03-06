
package edu.isu.cs.cs3308.traversals;

import edu.isu.cs.cs3308.structures.impl.LinkedBinaryTree;
import edu.isu.cs.cs3308.traversals.commands.TraversalCommand;

public abstract class AbstractTraversal<E> implements TreeTraversal {
    LinkedBinaryTree<E> tree;
    public AbstractTraversal(LinkedBinaryTree<E> t) {
        tree = t;
    }
    public void setCommand(TraversalCommand cmd){}

}