package hw6_20001976_phambathang.bai1;

@SuppressWarnings("unchecked,rawtypes")
public class TestDrive {
    public static void main(String[] args) {
        PriorityQueueInterface<Integer, String> test = new UnsortedArrayPriorityQueue<>(3);
        System.out.println("UnsortedArrayPriorityQueue Test");
        System.out.println("First Insert");
        test.insert(-3, "A");
        for (Entry entry : test) {
            System.out.println(entry);
        }
        System.out.println("Next Insert");
        test.insert(-2, "B");
        test.insert(-1, "C");
        for (Entry entry : test) {
            System.out.println(entry);
        }
        System.out.println("OverFlow Test");
        test.insert(4, "D");
        System.out.println("Min: " + test.removeMin());
        for (Entry entry : test) {
            System.out.println(entry);
        }
        System.out.println("------------------------------------------------------------");
        test = new SortedArrayPriorityQueue(3);
        System.out.println("SortedArrayPriorityQueue Test");
        System.out.println("First Insert");
        test.insert(-3, "A");
        for (Entry entry : test) {
            System.out.println(entry);
        }
        System.out.println("Next Insert");
        test.insert(-1, "C");
        test.insert(-2, "B");
        for (Entry entry : test) {
            System.out.println(entry);
        }
        System.out.println("OverFlow Test");
        test.insert(4, "D");
        System.out.println("Min: " + test.removeMin());
        for (Entry entry : test) {
            System.out.println(entry);
        }
    }
}
