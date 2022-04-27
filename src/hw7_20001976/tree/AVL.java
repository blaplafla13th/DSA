package hw7_20001976.tree;

public class AVL<T extends Comparable<? super T>> extends BinarySearchTree<T> {
    @Override
    protected Node<T> insert(Node<T> node, T data) {
        Node<T> newNode = super.insert(node, data);
        acceptChildren(newNode);
        newNode = balance(newNode);
        acceptChildren(newNode);
        return newNode;
    }

    @Override
    protected Node<T> delete(Node<T> node, T data) {
        Node<T> newNode = super.delete(node, data);
        acceptChildren(newNode);
        newNode = balance(newNode);
        acceptChildren(newNode);
        return newNode;
    }

    private void acceptChildren(Node<T> newNode) {
        if (newNode != null) {
            if (newNode.right != null)
                newNode.right.parent = root;
            if (newNode.left != null)
                newNode.left.parent = root;
        }
    }

    private Node<T> rotateRight(Node<T> node) {
        Node<T> leftChild = node.left;
        if (leftChild != null) {
            node.left = leftChild.right;
            leftChild.right = node;
        }
        acceptChildren(node);
        acceptChildren(leftChild);
        return leftChild;
    }

    private Node<T> rotateLeft(Node<T> node) {
        Node<T> rightChild = node.right;
        if (rightChild != null) {
            node.right = rightChild.left;
        }
        acceptChildren(node);
        acceptChildren(rightChild);
        return rightChild;
    }

    private int balanceFactor(Node<T> node) {
        return node == null ? 0 : height(node.right) - height(node.left);
    }

    // https://www.quora.com/How-many-cases-are-there-for-rebalancing-AVL-trees/answer/Paolo-Maresca
    private Node<T> balance(Node<T> node) {
        int balance = balanceFactor(node);
        if (balance < -1 && node.right != null && balanceFactor(node.right) < 0)
            return rotateLeft(node);
        if (balance > 1 && node.left != null && balanceFactor(node.left) > 0)
            return rotateRight(node);
        if (balance < -1 && node.right != null && balanceFactor(node.right) > 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }
        if (balance > 1 && node.right != null && balanceFactor(node.left) < 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }
        return node;
    }
}
