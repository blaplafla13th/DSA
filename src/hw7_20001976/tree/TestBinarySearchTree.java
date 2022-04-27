package hw7_20001976.tree;

import java.util.Random;

public class TestBinarySearchTree {
    public static void main(String[] args) {
        int[] input = new int[50];
        for (int i = 0; i < input.length; i++) {
            input[i] = noDup(input, new Random(), i, 60);
        }
        for (int i : input) {
            System.out.print(i + " ");
        }
        System.out.println();
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        System.out.println("---------------------------------------\nTest BinarySearchTree");
        testTree(tree, input);
        System.out.println("---------------------------------------\nTest AVL Tree");
        tree = new AVL<>();
        testTree(tree, input);
    }

    private static void testTree(BinarySearchTree<Integer> tree, int[] input) {
        for (int i : input) {
            tree.insert(i);
        }
        tree.printTree();
        System.out.println("Search index 13 in input: " + tree.search(input[13]).data);
        System.out.println("Min: " + tree.findMin().getData());
        System.out.println("Delete index 5 in input: " + input[5]);
        tree.delete(input[5]);
        System.out.println("Delete index 11 in input " + input[11]);
        tree.delete(input[11]);
        System.out.println("Delete index 7 in input " + input[7]);
        tree.delete(input[7]);
        tree.printTree();
        System.out.println("Delete not in tree element");
        tree.delete(-1);
        System.out.println("Search index 20 in input: " + tree.search(input[20]).data);
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
