package hw7_20001976.bai1;

public class ArrayListSearchTest {
    public static void main(String[] args) {
        try {
            System.out.println("------------------------------");
            System.out.println("random 100000000 number");
            SimpleArrayList<Integer> list = new SimpleArrayList<>(100000001);
            for (int i = 0; i <= 100000000; i++) {
                list.add((int) (Math.random() * Integer.MAX_VALUE / 10));
            }
            System.out.println("------------------------------");
            Search<Integer> arraylist_search = new LinearSearch<>(list);
            System.out.println("Unsorted Linear Search");
            System.out.println("Tim so 1000000");
            arraylist_search.getRunningTime(1000000);
            System.out.println("Tim so 10000000");
            arraylist_search.getRunningTime(10000000);
            System.out.println("Tim so 100000000");
            arraylist_search.getRunningTime(100000000);
            System.out.println("------------------------------");
            System.out.println("random 100000000 number");
            list = new SimpleArrayList<>(100000001);
            for (int i = 0; i < 100000001; i++) {
                list.add(i);
            }
            System.out.println("------------------------------");
            arraylist_search = new LinearSearch<>(list);
            System.out.println("Sorted Linear Search");
            System.out.println("Tim so 1000000");
            arraylist_search.getRunningTime(1000000);
            System.out.println("Tim so 10000000");
            arraylist_search.getRunningTime(10000000);
            System.out.println("Tim so 100000000");
            arraylist_search.getRunningTime(100000000);
            System.out.println("------------------------------");
            arraylist_search = new BinarySearch<>(list);
            System.out.println("Sorted Binary Search");
            System.out.println("Tim so 1000000");
            arraylist_search.getRunningTime(1000000);
            System.out.println("Tim so 10000000");
            arraylist_search.getRunningTime(10000000);
            System.out.println("Tim so 100000000");
            arraylist_search.getRunningTime(100000000);
        } catch (OutOfMemoryError e) {
            System.out.println("Tran heap, them cac doi VM option de chay '-Xms4096M -Xmx4096M' hoac comment de chay tung doan");
        }
    }
}
