package hw7_20001976.node_search;

public class BinarySearchTree<K extends Comparable<? super K>> extends Search<K> {
    protected TreeNode<K> root;

    @Override
    public Node<K> insert(K data) {
        if (data == null) {
            return null;
        }
        size++;
        TreeNode<K> temp = new TreeNode<>(data);
        if (root == null) {
            root = temp;
        } else {
            TreeNode<K> parent = root;
            while (parent.left != temp && parent.right != temp)
                if (data.compareTo(parent.key) > 0)
                    if (parent.right == null)
                        parent.right = temp;
                    else parent = parent.right;
                else if (data.compareTo(parent.key) <= 0)
                    if (parent.left == null)
                        parent.left = temp;
                    else parent = parent.left;
        }
        return temp;
    }

    @Override
    public boolean isContain(K data) {
        if (data == null) {
            return false;
        }
        TreeNode<K> temp = root;
        while (temp != null) {
            if (temp.getKey().equals(data))
                return true;
            else if (data.compareTo(temp.getKey()) > 0)
                temp = temp.right;
            else if (data.compareTo(temp.getKey()) < 0)
                temp = temp.left;
        }
        return false;
    }

    @Override
    public Node<K> getItem(K data) {
        if (data == null) {
            return null;
        }
        TreeNode<K> temp = root;
        while (temp != null) {
            if (temp.getKey().equals(data))
                return temp;
            else if (temp.getKey().compareTo(data) > 0)
                temp = temp.right;
            else if (temp.getKey().compareTo(data) < 0)
                temp = temp.left;
        }
        return null;
    }

    public Node<K> findMin(TreeNode<K> node) {
        if (!isContain(node.key)) {
            return null;
        }
        while (node.left != null)
            node = node.left;
        return node;
    }

    protected TreeNode<K> getSuccessor(TreeNode<K> node) {
        if (!isContain(node.key)) {
            return null;
        }
        if (node.right != null)
            return (TreeNode<K>) findMin(node.right);
        else {
            while (node.parent != null && node == node.parent.right) {
                node = node.parent;
            }
            return node;
        }
    }

    public void delete(TreeNode<K> node) {
        if (!isContain(node.key)) {
            return;
        }
        boolean deleted = false;
        size--;
        while (!deleted)
            if (node.left == null && node.right == null) {
                if (node == node.parent.left) {
                    node.parent.left = null;
                    deleted = true;
                } else if (node == node.parent.right) {
                    node.parent.right = null;
                    deleted = true;
                }
            } else if (node.left != null && node.right != null) {
                TreeNode<K> temp = getSuccessor(node);
                node.key = temp.key;
                delete(temp);
            } else {
                if (node.left == null) {
                    node.key = node.right.key;
                    delete(node.right);
                }
                if (node.right == null) {
                    node.key = node.left.key;
                    delete(node.left);
                }
            }
    }

    public TreeNode<K> getRoot() {
        return root;
    }

    public int height(TreeNode<K> node) {
        if (node == null) {
            return 0;
        }
        if (!isContain(node.key)) {
            return 0;
        }
        return 1 + Math.max((node.left != null) ? this.height(node.left) : 0,
                (node.right != null) ? this.height(node.right) : 0);
    }

    public class TreeNode<K extends Comparable<? super K>> extends Node<K> {
        protected TreeNode<K> parent;
        protected TreeNode<K> left;
        protected TreeNode<K> right;

        public TreeNode(K k) {
            super(k);
        }

        public TreeNode<K> getParent() {
            return parent;
        }

        public void setParent(TreeNode<K> parent) {
            this.parent = parent;
        }

        public TreeNode<K> getLeft() {
            return left;
        }

        public void setLeft(TreeNode<K> left) {
            this.left = left;
        }

        public TreeNode<K> getRight() {
            return right;
        }

        public void setRight(TreeNode<K> right) {
            this.right = right;
        }
    }
}
