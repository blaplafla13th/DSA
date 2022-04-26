package hw7_20001976.tree;

public class LinkedBinaryTree<E> {
    protected Node<E> node;
    protected int size = 0;

    public LinkedBinaryTree() {
        this.node = null;
    }

    public Node<E> addRoot(E element) {
        if (this.node == null) {
            node = new Node<>(element, null, null, null);
            size++;
        } else System.out.println("Tree has root already");
        return node;
    }

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

    public void set(Node<E> p, E element) {
        if (p == null) {
            System.out.println("Node unknown");
        } else {
            p.data = element;
        }
    }

    public void setLeft(Node<E> p, E element) {
        if (p == null) {
            System.out.println("Node unknown");
        } else if (p.left == null) {
            addLeft(p, element);
        } else {
            p.left.data = element;
        }
    }

    public void setRight(Node<E> p, E element) {
        if (p == null) {
            System.out.println("Node unknown");
        } else if (p.right == null) {
            addRight(p, element);
        } else {
            p.right.data = element;
        }
    }

    public Node<E> root() {
        return node;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

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

    public Node<E> parent(Node<E> p) {
        if (p == null) {
            System.out.println("Node unknown");
            return null;
        }
        return p.parent;
    }

    public Node<E> left(Node<E> p) {
        if (p == null) {
            System.out.println("Node unknown");
            return null;
        }
        return p.left;
    }

    public Node<E> right(Node<E> p) {
        if (p == null) {
            System.out.println("Node unknown");
            return null;
        }
        return p.right;
    }

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

    public E value(Node<E> p) {
        if (p == null) {
            System.out.println("Node unknown");
            return null;
        }
        return p.data;
    }

    public int height(Node<E> p) {
        return this.isEmpty() || p == null ? 0 : 1 + Math.max(p.left != null ? this.height(this.left(p)) : 0,
                p.right != null ? this.height(this.right(p)) : 0);
    }

    public void print(Node<E> node, int space) {
        if (size == 0) {
            return;
        }
        space += 1;
        if (node.getRight() != null) {
            print(node.getRight(), space);
        }
        System.out.print("\n");
        for (int i = 1; i < space; i++)
            System.out.print("\t");
        System.out.printf("%s\n", node.getData());
        if (node.getLeft() != null) {
            print(node.getLeft(), space);
        }
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

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public Node<E> getParent() {
            return parent;
        }

        public void setParent(Node<E> parent) {
            this.parent = parent;
        }

        public Node<E> getLeft() {
            return left;
        }

        public void setLeft(Node<E> left) {
            this.left = left;
        }

        public Node<E> getRight() {
            return right;
        }

        public void setRight(Node<E> right) {
            this.right = right;
        }
    }
}