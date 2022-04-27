package hw7_20001976.tree;

public class BinarySearchTree<T extends Comparable<? super T>> {
    protected Node<T> root;
    protected int size = 0;

    public Node<T> findMin() {
        return findMin(root);
    }

    protected Node<T> findMin(Node<T> root) {
        if (root == null)
            return null;
        while (root.getLeft() != null)
            root = root.getLeft();
        return root;
    }

    public Node<T> search(T data) {
        return search(root, data);
    }

    public Node<T> search(Node<T> root, T data) {
        if (data == null || root == null)
            return null;
        else if (root.getData().equals(data) || data.compareTo(root.getData()) == 0)
            return root;
        else if (data.compareTo(root.getData()) > 0)
            return search(root.getRight(), data);
        else if (data.compareTo(root.getData()) < 0)
            return search(root.getLeft(), data);
        else
            return null;
    }

    public void insert(T data) {
        size++;
        if (root == null)
            root = new Node<>(data);
        else
            insert(root, data);
    }

    protected Node<T> insert(Node<T> root, T data) {
        if (data == null)
            return null;
        else if (root == null) {
            root = new Node<>(data);
            return root;
        } else if (root.getData().compareTo(data) > 0) {
            root.left = insert(root.left, data);
            if (root.left != null)
                root.left.parent = root;
            return root;
        } else if (root.getData().compareTo(data) < 0) {
            root.right = insert(root.right, data);
            if (root.right != null)
                root.right.parent = root.right;
            return root;
        } else
            System.out.println("duplicated");
        return null;
    }

    public void delete(T data) {
        size--;
        delete(root, data);
    }

    protected Node<T> delete(Node<T> root, T data) {
        if (root == null)
            return null;
        else if (data.compareTo(root.getData()) < 0) {
            root.left = delete(root.left, data);
            if (root.left != null)
                root.left.parent = root;
        } else if (data.compareTo(root.getData()) > 0) {
            root.right = delete(root.right, data);
            if (root.right != null)
                root.right.parent = root;
        } else if (data.compareTo(root.getData()) == 0 && root.left == null)
            return root.right;
        else if (data.compareTo(root.getData()) == 0 && root.right == null)
            return root.left;
        else if (data.compareTo(root.getData()) == 0) {
            Node<T> successor = findMin(root.right);
            root.data = successor.data;
            root.right = delete(root.right, data);
            if (successor.parent.left == successor)
                successor.parent.left = null;
            else if (successor.parent.right == successor)
                successor.parent.right = null;
        }
        return root;
    }

    public void printTree() {
        print(this.root, 0);
    }

    public int height(Node<T> p) {
        return p == null ? 0 : 1 + Math.max(p.left != null ? this.height(p.left) : 0,
                p.right != null ? this.height(p.right) : 0);
    }

    public void print(Node<T> root, int space) {
        if (size == 0) {
            return;
        }
        space += 1;
        if (root.right != null) {
            print(root.right, space);
        }
        System.out.print("\n");
        for (int i = 1; i < space; i++)
            System.out.print("\t");
        System.out.printf("%s\n", root.getData());
        if (root.left != null) {
            print(root.left, space);
        }
    }

    protected static class Node<E> {
        protected E data; // an data stored at this root
        protected Node<E> parent; // the parent of this node
        protected Node<E> left; // a reference to the left child
        protected Node<E> right; // a reference to the right child

        // Constructs a root with the given data and neighbors. ∗/

        protected Node(E data) {
            this.data = data;
        }

        protected E getData() {
            return data;
        }

        protected Node<E> getLeft() {
            return left;
        }

        protected Node<E> getRight() {
            return right;
        }

        public Node<E> getParent() {
            return parent;
        }
    }
}
