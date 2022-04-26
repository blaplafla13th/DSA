package hw7_20001976.tree;

public class BinarySearchTree<T extends Comparable<? super T>> {
    protected LinkedBinaryTree<T> tree;

    public BinarySearchTree() {
        this.tree = new LinkedBinaryTree<>();
    }

    public LinkedBinaryTree.Node<T> findMin() {
        return findMin(tree.root());
    }

    protected LinkedBinaryTree.Node<T> findMin(LinkedBinaryTree.Node<T> node) {
        if (node == null)
            return null;
        while (node.getLeft() != null)
            node = node.getLeft();
        return node;
    }

    public LinkedBinaryTree.Node<T> search(T data) {
        return search(tree.root(), data);
    }

    public LinkedBinaryTree.Node<T> search(LinkedBinaryTree.Node<T> node, T data) {
        if (data == null || node == null)
            return null;
        else if (node.getData().equals(data))
            return node;
        else if (data.compareTo(node.getData()) > 0)
            return search(node.getRight(), data);
        else if (data.compareTo(node.getData()) < 0)
            return search(node.getLeft(), data);
        else
            return null;
    }

    public void insert(T data) {
        if (tree.root() == null)
            tree.addRoot(data);
        else
            insert(tree.root(), data);
    }

    protected LinkedBinaryTree.Node<T> insert(LinkedBinaryTree.Node<T> node, T data) {
        if (data == null)
            return null;
        else if (node == null) {
            node = new LinkedBinaryTree.Node<>(data, null, null, null);
            return node;
        } else if (node.getData().compareTo(data) > 0) {
            node.setLeft(insert(node.getLeft(), data));
            node.getLeft().setParent(node);
            return node;
        } else if (node.getData().compareTo(data) < 0) {
            node.setRight(insert(node.getRight(), data));
            node.getRight().setParent(node);
            return node;
        } else
            System.out.println("duplicated");
        return null;
    }

    public void delete(T data) {
        delete(tree.root(), data);
    }

    protected LinkedBinaryTree.Node<T> delete(LinkedBinaryTree.Node<T> node, T data) {
        if (node == null)
            return null;
        else if (data.compareTo(node.getData()) < 0) {
            LinkedBinaryTree.Node<T> newNode = delete(node.getLeft(), data);
            node.setLeft(newNode);
            if (newNode != null && (newNode == node.getRight() || newNode == node.getLeft()))
                newNode.setParent(node.getParent());
            return newNode;
        } else if (data.compareTo(node.getData()) > 0) {
            LinkedBinaryTree.Node<T> newNode = delete(node.getRight(), data);
            node.setRight(newNode);
            if (newNode != null && (newNode == node.getRight() || newNode == node.getLeft()))
                newNode.setParent(node.getParent());
            return newNode;
        } else if (node.getLeft() == null && node.getRight() == null)
            node = null;
        else
            deleteNodeWithTwoChildren(node);
        return node;
    }

    private void deleteNodeWithTwoChildren(LinkedBinaryTree.Node<T> node) {
        LinkedBinaryTree.Node<T> successor = findMin(node);
        node.setData(successor.getData());
        node.setRight(delete(node.getRight(), successor.getData()));
    }

    public void printTree() {
        tree.print(tree.root(), 0);
    }
}
