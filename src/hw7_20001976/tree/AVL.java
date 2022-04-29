package hw7_20001976.tree;

public class AVL<T extends Comparable<? super T>> extends BinarySearchTree<T> {
    @Override
    public void insert(T data) {
        super.insert(data);
        updateRoot();
    }

    @Override
    public void delete(T data) {
        super.delete(data);
        updateRoot();
    }

    @Override
    protected Node<T> insert(Node<T> node, T data) {
        node = super.insert(node, data);
        return balance(node);
    }

    @Override
    protected Node<T> delete(Node<T> node, T data) {
        node = super.delete(node, data);
        if (node == null) {
            return null;
        }
        return balance(node);
    }


    private Node<T> rotateRight(Node<T> node) {
        Node<T> leftChild = node.left;
        if (leftChild != null) {
            node.left = leftChild.right;
            if (node.left != null)
                node.left.parent = node;
            leftChild.right = node;
            leftChild.right.parent = leftChild;
            return leftChild;
        }
        return node;
    }

    private Node<T> rotateLeft(Node<T> node) {
        Node<T> rightChild = node.right;
        if (rightChild != null) {
            node.right = rightChild.left;
            if (node.right != null) node.right.parent = node;
            rightChild.left = node;
            rightChild.left.parent = rightChild;
            return rightChild;
        }
        return node;
    }

    private int balanceFactor(Node<T> node) {
        return node == null ? 0 : height(node.right) - height(node.left);
    }

    private void updateRoot() {
        if (root.parent != null) {
            root = root.parent;
            root.parent = null;
        }
    }

    private Node<T> balance(Node<T> node) {
        int balance = balanceFactor(node);
        if (balance != 0) {
            if (balance > 1 && node.right != null && balanceFactor(node.right) >= 0)
                node = rotateLeft(node);
            else if (balance < -1 && node.left != null && balanceFactor(node.left) <= 0)
                node = rotateRight(node);
            else if (balance < -1 && node.left != null && balanceFactor(node.left) > 0) {
                node.left = rotateLeft(node.left);
                node = rotateRight(node);
            } else if (balance > 1 && node.right != null && balanceFactor(node.right) < 0) {
                node.right = rotateRight(node.right);
                node = rotateLeft(node);
            }
        }
        return node;
    }
}
