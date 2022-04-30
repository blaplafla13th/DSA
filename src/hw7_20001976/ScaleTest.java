package hw7_20001976;

import hw7_20001976.list.BinarySearch;
import hw7_20001976.list.LinearSearch;
import hw7_20001976.list.SimpleArrayList;
import hw7_20001976.tree.AVL;
import hw7_20001976.tree.BinarySearchTree;

public class ScaleTest {
    public static void main(String[] args) {
        SimpleArrayList<Integer> testArray = new SimpleArrayList<>();
        System.out.println("Insert 1 million numbers");
        for (int i = 0; i < 100; i++) {
            testArray.add(i);
        }
        test(testArray);
        System.out.println("Insert 10 million numbers");
        for (int i = 1000000; i < 10000000; i++) {
            testArray.add(i);
        }
        test(testArray);
        System.out.println("Insert 100 million numbers");
        for (int i = 10000000; i < 100000000; i++) {
            testArray.add(i);
        }
        test(testArray);
    }

    private static void test(SimpleArrayList<Integer> testArray) {
        try {
            int num = (int) (Math.random() * testArray.size());
            System.out.println("Find number:" + num);
            System.out.println("-----------------");
            linear(testArray, num);
            System.out.println("-----------------");
            binarySearch(testArray, num);
            System.out.println("-----------------");
            binarySearchTree(testArray, num);
            System.out.println("-----------------");
            avl(testArray, num);
        } catch (StackOverflowError e) {
            System.out.println("use -Xss to increase stack");
        } catch (OutOfMemoryError e) {
            System.out.println("use -Xmx to increase stack");
        }
    }

    private static void linear(SimpleArrayList<Integer> testArray, int num) {
        System.out.println("Linear Search");
        LinearSearch<Integer> linear = new LinearSearch<>(testArray);
        System.out.println("Random case");
        linear.getRunningTime(num);
        System.out.println("Best case");
        linear.getRunningTime(1);
        System.out.println("Worst case");
        linear.getRunningTime(testArray.size() - 1);
        // best case:1 worst case: n
    }

    private static void binarySearch(SimpleArrayList<Integer> testArray, int num) {
        System.out.println("Binary Search");
        BinarySearch<Integer> binary = new BinarySearch<>(testArray);
        System.out.println("Random case");
        binary.getRunningTime(num);
        System.out.println("Best case");
        binary.getRunningTime(1);
        // best case:1 worst case: log(2)n
    }

    private static void binarySearchTree(SimpleArrayList<Integer> testArray, int num) {
        System.out.println("Binary Search Tree");
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        System.out.println("Inserting");
        long time = System.nanoTime();
        for (int i : testArray) {
            System.out.println(i);
            bst.insert(i);
        }
        time = System.nanoTime() - time;
        System.out.printf("insert mat %.3f ms \n", time / 1000000.0);
        System.out.println("Random case");
        bst.getRunningTime(num);
        // best case 1 worse case n
    }

    private static void avl(SimpleArrayList<Integer> testArray, int num) {
        System.out.println("AVL Search Tree");
        BinarySearchTree<Integer> avl = new AVL<>();
        System.out.println("Inserting");
        long time = System.nanoTime();
        for (int i : testArray) {
            System.out.println(i);
            avl.insert(i);
        }
        time = System.nanoTime() - time;
        System.out.printf("insert mat %.3f ms \n", time / 1000000.0);
        System.out.println("Random case");
        avl.getRunningTime(num);
        // best case 1 worst case log n
    }
}
