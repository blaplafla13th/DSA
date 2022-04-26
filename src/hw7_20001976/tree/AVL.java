package hw7_20001976.tree;

public class AVL<T extends Comparable<? super T>> extends BinarySearchTree<T> {
    @Override
    protected LinkedBinaryTree.Node<T> insert(LinkedBinaryTree.Node<T> node, T data) {
        return balance(super.insert(node, data));
    }

    @Override
    protected LinkedBinaryTree.Node<T> delete(LinkedBinaryTree.Node<T> node, T data) {
        return balance(super.delete(node, data));
    }

    private LinkedBinaryTree.Node<T> rotateRight(LinkedBinaryTree.Node<T> node) {
        LinkedBinaryTree.Node<T> leftChild = node.getLeft();
        node.setLeft(leftChild.getRight());
        leftChild.setRight(node);
        return leftChild;
    }

    private LinkedBinaryTree.Node<T> rotateLeft(LinkedBinaryTree.Node<T> node) {
        LinkedBinaryTree.Node<T> rightChild = node.getRight();
        node.setRight(rightChild.getLeft());
        rightChild.setLeft(node);
        return rightChild;
    }

    private int balanceFactor(LinkedBinaryTree.Node<T> node) {
        return tree.height(node.getRight()) - tree.height(node.getLeft());
    }

    private LinkedBinaryTree.Node<T> balance(LinkedBinaryTree.Node<T> node) {
        int balanceFactor = balanceFactor(node);
        if (balanceFactor < -1) {
            if (balanceFactor(node.getLeft()) <= 0) {
                node = rotateRight(node);
            } else {
                node.setLeft(rotateLeft(node.getLeft()));
                node = rotateRight(node);
            }
        }
        if (balanceFactor > 1) {
            if (balanceFactor(node.getRight()) >= 0) {
                node = rotateLeft(node);
            } else {
                node.setRight(rotateRight(node.getRight()));
                node = rotateLeft(node);
            }
        }
        return node;
    }
}
