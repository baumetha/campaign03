/**
 * @author Ethan Baumgartner
 * References from the book examples
 */
package edu.isu.cs.cs3308.structures.impl;

import edu.isu.cs.cs3308.structures.BinaryTree;
import edu.isu.cs.cs3308.structures.Node;
import edu.isu.cs.cs3308.structures.Tree;

import java.util.ArrayList;
import java.util.List;

public class LinkedBinaryTree<E> implements BinaryTree<E>, Tree<E> {
    /**
     * Nested Node class from the book
     * @param <E> type of item
     */
    public static class BinaryTreeNode<E> implements Node<E> {
        private E element;
        private Node<E> parent;
        private Node<E> left;
        private Node<E> right;

        public BinaryTreeNode(E e, Node<E> top, Node<E> leftLeaf, Node<E> rightLeaf) {
            element = e;
            parent = top;
            left = leftLeaf;
            right = rightLeaf;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getParent() {
            return parent;
        }

        public Node<E> getLeft() {
            return left;
        }

        public Node<E> getRight() {
            return right;
        }

        public void setElement(E e) {
            element = e;
        }

        public void setParent(Node<E> parentNode) {
            parent = parentNode;
        }

        public void setLeft(Node<E> leftChild) {
            left = leftChild;
        }

        public void setRight(Node<E> rightChild) {
            right = rightChild;
        }
    }

    /**
     * Creates a new node
     * Taken from the book examples
     * @param e The data
     * @param parent parent of the tree
     * @param left left child of the tree
     * @param right right child of the tree
     * @return the created node
     */
    protected Node<E> createNode(E e, Node<E> parent, Node<E> left, Node<E> right) {
        if (e == null){
            throw new IllegalArgumentException();
        }
        return new BinaryTreeNode<>(e, parent, left, right);
    }

    protected Node<E> root = null;
    private int size = 0;

    public LinkedBinaryTree() {

    }

    /**
     * Checks the provided node
     * Taken from the book examples
     * @param p The node to be validated.
     * @return returns the node
     * @throws IllegalArgumentException
     */
    public Node<E> validate(Node<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node))
            throw new IllegalArgumentException();
        Node<E> node = p;
        if (node.getParent() == null && node != root)
            throw new IllegalArgumentException("p is not in the tree");
        return p;
    }

    /**
     * The number of nodes in the tree
     * @return the number of nodes
     */
    public int size() {
        return size;
    }

    /**
     * Root of the tree
     * @return
     */
    public Node<E> root() {
        return root;
    }

    /**
     * Taken from the book examples
     * @param p Node whose parent is being requested.
     * @return the parent node
     * @throws IllegalArgumentException
     */
    public Node<E> parent(Node<E> p) throws IllegalArgumentException {
        BinaryTreeNode<E> node = (BinaryTreeNode<E>) validate(p);
        return node.getParent();
    }

    /**
     * Taken from the book examples
     * @param p The parent node of whom the left child is desired.
     * @return the left child
     * @throws IllegalArgumentException
     */
    public Node<E> left(Node<E> p) throws IllegalArgumentException {
        BinaryTreeNode<E> node = (BinaryTreeNode<E>) validate(p);
        return node.getLeft();
    }

    /**
     * Taken from the book examples
     * @param p The parent node of whom the right child is desired.
     * @return the right child
     * @throws IllegalArgumentException
     */
    public Node<E> right(Node<E> p) throws IllegalArgumentException {
        BinaryTreeNode<E> node = (BinaryTreeNode<E>) validate(p);
        return node.getRight();
    }

    /**
     * Taken from the book
     * Moves the node to the left
     * @param p The node to which the element is to be added as the left child.
     * @param e item to be added
     * @return the child on the left
     * @throws IllegalArgumentException
     */
    public Node<E> addLeft(Node<E> p, E e) throws IllegalArgumentException {
        BinaryTreeNode<E> parent = (BinaryTreeNode<E>) validate(p);
        if (parent.getLeft() != null)
            throw new IllegalArgumentException();
        Node child = createNode(e, parent, null, null);
        parent.setLeft(child);
        size++;
        return child;
    }

    /**
     * Taken from the book
     * moves the node to the right
     * @param p The node to which the element is to be added as the right child.
     * @param e item to be added
     * @return the child on the right
     * @throws IllegalArgumentException
     */
    public Node addRight(Node<E> p, E e) throws IllegalArgumentException {
        BinaryTreeNode<E> parent = (BinaryTreeNode<E>) validate(p);
        if (parent.getRight() != null)
            throw new IllegalArgumentException();
        Node<E> child = createNode(e, parent, null, null);
        parent.setRight(child);
        size++;
        return child;
    }

    /**
     * Taken from the book
     * @param p The node to which is to be set
     * @param e item ti be set
     * @return the temp storage of the node
     * @throws IllegalArgumentException
     */
    public E set(Node<E> p, E e) throws IllegalArgumentException {
        BinaryTreeNode<E> node = (BinaryTreeNode<E>) validate(p);
        if (e == null || node == null)
            throw new IllegalArgumentException();
        E temp = node.getElement();
        node.setElement(e);
        return temp;
    }

    /**
     * taken from the book
     * @param p The node of whom a sibling is requested.
     * @return
     */
    public Node<E> sibling(Node<E> p) {
        Node<E> parent = parent(p);
        if (parent == null)
            return null;
        if (p == left(parent))
            return right(parent);
        else
            return left(parent);
    }

    /**
     * Taken from book
     * @param p Node whose number of children is requested.
     * @return returns the number of children
     * @throws IllegalArgumentException
     */
    public int numChildren(Node<E> p)throws IllegalArgumentException {
        int count = 0;
        if (left(p) != null)
            count++;
        if (right(p) != null)
            count++;
        return count;
    }

    /**
     * Taken from book
     * @param p The node whose children are requested.
     * @return returns the children of the tree
     * @throws IllegalArgumentException
     */
    public Iterable<Node<E>> children(Node<E> p) throws IllegalArgumentException {
        List<Node<E>> snapshot = new ArrayList<>(2);
        if (left(p) != null)
            snapshot.add(left(p));
        if (right(p) != null)
            snapshot.add(right(p));
        return snapshot;
    }

    /**
     * Taken from the book
     * @param e item to be set
     * @return places at the top of the tree
     * @throws IllegalArgumentException
     */
    public Node<E> setRoot(E e) throws IllegalArgumentException {
        if (e == null) {
            size = 0;
            return null;
        }
        if (!isEmpty()) throw new IllegalStateException();
        root = createNode(e, null, null, null);
        size = 1;
        return root;
    }

    /**
     * From book
     * checks if internal
     * @param p The node to test.
     * @return number of children
     * @throws IllegalArgumentException
     */
    public boolean isInternal(Node<E> p) throws IllegalArgumentException {
        return numChildren(p) > 0;
    }

    /**
     * from book
     * checks if external
     * @param p The node to test.
     * @return Number of children
     * @throws IllegalArgumentException
     */
    public boolean isExternal(Node<E> p) throws IllegalArgumentException {
        return numChildren(p) == 0;
    }

    /**
     * from book
     * Checks if node is the root
     * @param p Node to test.
     * @return returns the root
     * @throws IllegalArgumentException
     */
    public boolean isRoot(Node<E> p)throws IllegalArgumentException{
        return p == root;
    }

    /**
     * Inserts the item based on which side of the tree is empty
     * @param e item to be added
     * @param p The parent node of the tree, if null the item becomes the new
     * root so beaware.
     * @return the side to add the item
     */
    public Node<E> insert(E e, Node<E> p){
        if (e == null) throw new IllegalArgumentException();
        BinaryTreeNode<E> node = (BinaryTreeNode<E>) validate(p);

        if (node.getLeft() == null) {
            return addLeft(node, e);
        }
        else if (node.getRight() == null) {
            return addRight(node, e);
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Removes the item
     * Not implemented
     * @param item Item to be removed from the list of children of the provided
     * node.
     * @param p Parent node.
     * @return
     * @throws IllegalArgumentException
     */
    public boolean remove(E item, Node<E> p) throws IllegalArgumentException {
        return false;
    }

    /**
     * Checks if the tree is empty
     * @return true or false
     */
    public boolean isEmpty() {
        if (size == 0){
            return true;
        }
        return false;
    }

    /**
     * from book
     * Looks at how many layers the tree has
     * @param node Node whose depth is to be calculated
     * @return the levels
     * @throws IllegalArgumentException
     */
    public int depth(Node<E> node) throws IllegalArgumentException {
        if (isRoot(node))
            return 0;
        else
            return 1 + depth(parent(node));
    }

    public int subTreeSize(Node<E> node) throws IllegalArgumentException {
        return 0;
    }

    public boolean isLastChild(Node<E> node) throws IllegalArgumentException {
        return false;
    }
}
