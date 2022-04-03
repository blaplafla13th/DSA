package hw5_20001976;

import hw5_20001976.bai1.LinkedBinaryTree;
import hw5_20001976.bai1.LinkedBinaryTree.Node;

import java.io.File;
import java.util.Formatter;

public class Bai1Y3Linked {
    static Formatter formatter;
    static File file = new File("out.txt");

    public static void main(String[] args) {
        LinkedBinaryTree<Integer> linkedBinaryTree = new LinkedBinaryTree<>();
        add(linkedBinaryTree.addRoot(0), 0, linkedBinaryTree, 0, 2);
        System.out.println(linkedBinaryTree.height(linkedBinaryTree.root()));
        try {
            if (file.exists()) {
                file.delete(); // remove old file
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        print(linkedBinaryTree.root(), 0, linkedBinaryTree);
        formatter.flush();
        formatter.close();
        // 7 node tree
//              0
//        1           2
//    3       4   5       6
    }

    public static void add(Node<Integer> startPosition, int startValue, LinkedBinaryTree<Integer> list, int height, int maxHeight) {
        if (height < maxHeight) {
            add(list.addLeft(startPosition, 2 * startValue + 1), 2 * startValue + 1, list, height + 1, maxHeight);
            add(list.addRight(startPosition, 2 * startValue + 2), 2 * startValue + 2, list, height + 1, maxHeight);
        }
    }

    public static void print(Node<Integer> position, int space, LinkedBinaryTree<Integer> list) {
        try {
            if (!file.exists()) {
                file.createNewFile();
                formatter = new Formatter("out.txt");
            }
            if (list.isEmpty())
                return;
            space += 1;
            // process right

            if (list.right(position) != null)
                print(list.right(position), space, list);
            //print self
            formatter.format("\n");
            for (int i = 1; i < space; i++)
                formatter.format("\t");
            formatter.format("%d\n", list.value(position));
            // process left
            if (list.left(position) != null)
                print(list.left(position), space, list);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
