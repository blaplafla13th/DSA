package hw5_20001976;

import hw5_20001976.bai1.ArrayBinaryTree;

import java.io.File;
import java.util.Formatter;

public class Bai1Y3Array {
    static Formatter formatter;
    static File file = new File("out.txt");

    public static void main(String[] args) {
        int layer = 3;
        int maxSize = (int) Math.pow(2, layer) - 1;
        ArrayBinaryTree<Integer> arrayBinaryTree = new ArrayBinaryTree<>(maxSize);
        add(arrayBinaryTree.addRoot(0), 0, arrayBinaryTree, 0, layer);
        System.out.println(arrayBinaryTree.height(0));
        try {
            if (file.exists()) {
                file.delete(); // remove old file
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        print(arrayBinaryTree.root(), 0, arrayBinaryTree);
        formatter.flush();
        formatter.close();
        // 7 node tree
//              0
//        1           2
//    3       4   5       6
    }

    public static void add(int startPosition, int startValue, ArrayBinaryTree<Integer> array, int height, int maxHeight) {
        if (height < maxHeight - 1) {
            add(array.addLeft(startPosition, 2 * startValue + 1), 2 * startValue + 1, array, height + 1, maxHeight);
            add(array.addRight(startPosition, 2 * startValue + 2), 2 * startValue + 2, array, height + 1, maxHeight);
        }
    }
    public static void print(int position, int space, ArrayBinaryTree<Integer> array) {
        try {
            if (!file.exists()) {
                file.createNewFile();
                formatter = new Formatter("out.txt");
            }

            if (array.isEmpty() && (position < 0 || position >= 7))
                return;
            space += 1;
            // process right
            if (position < array.size() && position >= 0) {
                if (position <= 2)
                    print(array.right(position), space, array);
                //print self
                formatter.format("\n");
                for (int i = 1; i < space; i++)
                    formatter.format("\t");
                formatter.format("%d\n", array.value(position));
                // process left
                if (position <= 2)
                    print(array.left(position), space, array);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
