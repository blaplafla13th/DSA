package hw6_20001976.bai2;

import hw6_20001976.bai1.Entry;

@SuppressWarnings("rawtypes,unchecked")
public class Test {
    public static void main(String[] args) {
        MinHeapPriorityQueue<Integer, String> test = new MinHeapPriorityQueue(10);
        System.out.println("MinHeapPriorityQueue Test");
        System.out.println("First Insert");
        test.insert(-3, "A");
        for (Entry entry : test) {
            System.out.println(entry);
        }
        System.out.println("Next Insert");
        test.insert(-1, "C");
        test.insert(-2, "B");
        test.insert(1, "B");
        test.insert(2, "B");
        test.insert(0, "B");
        test.insert(-6, "B");
        for (Entry entry : test) {
            System.out.println(entry);
        }
        System.out.println("Min: " + test.removeMin());
        for (Entry entry : test) {
            System.out.println(entry);
        }
        System.out.println("remove next min: " + test.removeMin());
        for (Entry entry : test) {
            System.out.println(entry);
        }
        while (!test.isEmpty()) System.out.println("remove next min: " + test.removeMin());
    }
}
