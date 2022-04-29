package hw7_20001976.tree;

import java.util.Random;

public class TestBinarySearchTree {
    public static void main(String[] args) {
        // Tree Data Structure https://www.happycoders.eu/algorithms/
        System.out.print("---------------------------------------\nCreating test:");
        int[] input = new int[50];
        for (int i = 0; i < input.length; i++) {
            input[i] = noDup(input, new Random(), i, 200); // max must be bigger than array or infinity loop
        }
        for (int i : input) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("---------------------------------------\nTest BinarySearchTree");
        BinarySearchTree<Integer> bts = new BinarySearchTree<>();
        testTree(bts, input);
        TreeViewer binarySearchTreeViewer = new TreeViewer(bts, "BinarySearchTree");
        System.out.println("---------------------------------------\nTest AVL Tree");
        AVL<Integer> avl = new AVL<>();
        testTree(avl, input);
        TreeViewer avlTreeViewer = new TreeViewer(avl, "AVL Tree");
    }

    private static void testTree(BinarySearchTree<Integer> tree, int[] input) {
        for (int i : input) {
            tree.insert(i);
        }
        BinarySearchTree.Node<Integer> search = tree.search(input[13]);
        System.out.println("Search index 13 in input: " + (search == null ? "Not Found" : search.data));
        System.out.println("Min: " + tree.findMin().getData());
        System.out.println("Delete index 5 in input: " + input[5]);
        tree.delete(input[5]);
        System.out.println("Delete index 11 in input: " + input[11]);
        tree.delete(input[11]);
        System.out.println("Delete index 7 in input: " + input[7]);
        tree.delete(input[7]);
        tree.printTree();
        System.out.println("Delete not in tree element");
        tree.delete(-1);
        search = tree.search(input[20]);
        System.out.println("Search index 20 in input after delete: " + (search == null ? "Not Found" : search.data));
        System.out.println("Remove min:");
        tree.delete(tree.findMin().getData());
        tree.printTree();
    }

    public static int noDup(int[] numbers, Random random, int i, int max) {
        if (numbers == null) {
            System.out.println("null");
            System.exit(0);
        }
        int newNum = random.nextInt(max + 1);
        while (isDup(numbers, i, newNum)) {
            newNum = random.nextInt(max + 1);
        }
        return newNum;
    }

    public static boolean isDup(int[] numbers, int i, int newNum) {
        if (numbers == null) {
            System.out.println("null");
            System.exit(0);
        }
        for (int j = 0; j < i; j++) {
            if (numbers[j] == newNum)
                return true;
        }
        return false;
    }

}
