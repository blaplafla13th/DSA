package hw7_20001976.node_search;

@SuppressWarnings("rawtypes")

public class TestTree {
    public static void main(String[] args) {
        BinarySearchTree<Integer> test = new BinarySearchTree<>();
        for (int i = 0; i < 10; i++) {
            test.insert(i);
        }
        print(test.root, 0, test);
        System.out.println("min: " + test.findMin(test.root));
        test.delete(test.root.right.right);
        print(test.root, 0, test);
        System.out.println();
        System.out.println("------------------------------");
        test = new AVL<>();
        for (int i = 0; i < 10; i++) {
            test.insert(i);
        }
        print(test.root, 0, test);
        System.out.println("min: " + test.findMin(test.root));

    }

    public static void print(BinarySearchTree.TreeNode treeNode, int space, BinarySearchTree<Integer> tree) {
        if (tree.getSize() == 0) {
            return;
        }
        space += 1;
        if (treeNode.getRight() != null) {
            print(treeNode.getRight(), space, tree);
        }
        System.out.print("\n");
        for (int i = 1; i < space; i++)
            System.out.print("\t");
        System.out.printf("%s\n", treeNode.getKey());
        if (treeNode.getLeft() != null) {
            print(treeNode.getLeft(), space, tree);
        }
    }
}
