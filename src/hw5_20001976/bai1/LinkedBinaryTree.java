package hw5_20001976.bai1;

public class LinkedBinaryTree<E> implements BinaryTreeInterface<E, LinkedBinaryTree.Node<E>> {
    Node<E> node;
    int size = 0;

    public LinkedBinaryTree() {
        this.node = null;
    }

    @Override
    public Node<E> addRoot(E element) {
        if (this.node == null) {
            node = new Node<>(element, null, null, null);
            size++;
        } else System.out.println("Tree has root already");
        return node;
    }

    @Override
    public Node<E> addLeft(Node<E> p, E element) {
        if (p == null) {
            System.out.println("Node unknown");
            return null;
        } else if (p.left != null) {
            System.out.println("Node has left already");
        } else {
            p.left = new Node<>(element, p, null, null);
            size++;
        }
        return p.left;
    }

    @Override
    public Node<E> addRight(Node<E> p, E element) {
        if (p == null) {
            System.out.println("Node unknown");
            return null;
        } else if (p.right != null) {
            System.out.println("Node has right already");
        } else {
            p.right = new Node<>(element, p, null, null);
            size++;
        }
        return p.right;
    }

    @Override
    public void set(Node<E> p, E element) {
        if (p == null) {
            System.out.println("Node unknown");
        } else {
            p.data = element;
        }
    }

    @Override
    public void setLeft(Node<E> p, E element) {
        if (p == null) {
            System.out.println("Node unknown");
        } else if (p.left == null) {
            addLeft(p, element);
        } else {
            p.left.data = element;
        }
    }

    @Override
    public void setRight(Node<E> p, E element) {
        if (p == null) {
            System.out.println("Node unknown");
        } else if (p.right == null) {
            addRight(p, element);
        } else {
            p.right.data = element;
        }
    }

    @Override
    public Node<E> root() {
        return node;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int numChildren(Node<E> p) {
        int count = 0;
        if (p == null) {
            System.out.println("Node unknown");
            return count;
        }
        if (p.left != null)
            count++;
        if (p.right != null)
            count++;
        return count;
    }

    @Override
    public Node<E> parent(Node<E> p) {
        if (p == null) {
            System.out.println("Node unknown");
            return null;
        }
        return p.parent;
    }

    @Override
    public Node<E> left(Node<E> p) {
        if (p == null) {
            System.out.println("Node unknown");
            return null;
        }
        return p.left;
    }

    @Override
    public Node<E> right(Node<E> p) {
        if (p == null) {
            System.out.println("Node unknown");
            return null;
        }
        return p.right;
    }

    @Override
    public Node<E> sibling(Node<E> p) {
        if (p == null) {
            System.out.println("Node unknown");
            return null;
        } else if (p.parent == null) {
            return null;
        } else if (p.parent.left == p)
            return p.parent.right;
        else if (p.parent.right == p)
            return p.parent.left;
        else return null;
    }

    @Override
    public E value(Node<E> p) {
        if (p == null) {
            System.out.println("Node unknown");
            return null;
        }
        return p.data;
    }

    public static class Node<E> {
        private E data; // an data stored at this node
        private Node<E> parent; // a reference to the parent node (if any)
        private Node<E> left; // a reference to the left child
        private Node<E> right; // a reference to the right child

        // Constructs a node with the given data and neighbors. ∗/

        public Node(E data, Node<E> parent, Node<E> left, Node<E> right) {
            this.data = data;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

    }
}