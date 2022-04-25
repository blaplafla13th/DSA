package hw7_20001976.node_search;

public class AVL<K extends Comparable<? super K>> extends BinarySearchTree<K> {
    private int balanceFactor(TreeNode<K> node) {
        return height(node.right) - height(node.left);
    }

    private TreeNode<K> rotateRight(TreeNode<K> y) {
        TreeNode<K> x = y.left;
        TreeNode<K> T2 = x.right;
        x.right = y;
        y.left = T2;
        return x;
    }

    private TreeNode<K> rotateLeft(TreeNode<K> x) {
        TreeNode<K> y = x.right;
        TreeNode<K> T2 = y.left;
        y.left = x;
        x.right = T2;
        return y;
    }

    private TreeNode<K> rebalance(TreeNode<K> node) {
        int balance = balanceFactor(node);
        if (balance > 1 && node.key.compareTo(node.left.key) < 0)
            return rotateRight(node);
        if (balance < -1 && node.key.compareTo(node.right.key) > 0)
            return rotateLeft(node);
        if (balance > 1 && node.key.compareTo(node.left.key) > 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }
        if (balance < -1 && node.key.compareTo(node.right.key) < 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }
        return node;
    }

    @Override
    public Node<K> insert(K data) {
        TreeNode<K> node = (TreeNode<K>) super.insert(data);
        return rebalance(node);
    }

    @Override
    public void delete(TreeNode<K> node) {
        super.delete(node);
        rebalance(node);
    }
}
