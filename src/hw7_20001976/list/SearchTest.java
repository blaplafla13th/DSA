package hw7_20001976.list;

public class SearchTest {
    public static void main(String[] args) {
        System.out.println("------------------------------");
        System.out.println("random 100 number");
        SimpleArrayList<Integer> arrayList = new SimpleArrayList<>(101);
        for (int i = 0; i <= 100; i++) {
            arrayList.add((int) (Math.random() * 100));
        }
        System.out.println("------------------------------");
        Search<Integer> arrayListSearch = new LinearSearch<>(arrayList);
        System.out.println("Unsorted Linear Search");
        System.out.println("Tim so 100");
        arrayListSearch.getRunningTime(100);
        System.out.println("Tim so 10");
        arrayListSearch.getRunningTime(10);
        System.out.println("Tim so 1");
        arrayListSearch.getRunningTime(1);
        System.out.println("------------------------------");
        System.out.println("convert 100 number array to LinkedList");
        SimpleLinkedList<Integer> linkedlist = new SimpleLinkedList<>();
        for (Integer i : arrayList) {
            linkedlist.add(i);
        }
        System.out.println("------------------------------");
        LinearSearchLinkedList<Integer> linkedListSearch = new LinearSearchLinkedList<>(linkedlist);
        System.out.println("Unsorted Linked List Linear Search");
        System.out.println("Tim so 100");
        linkedListSearch.getRunningTime(100);
        System.out.println("Tim so 10");
        linkedListSearch.getRunningTime(10);
        System.out.println("Tim so 1");
        linkedListSearch.getRunningTime(1);
        System.out.println("------------------------------");
        System.out.println("create sorted 100000000 number");
        arrayList = new SimpleArrayList<>(101);
        for (int i = 0; i < 101; i++) {
            arrayList.add(i);
        }
        System.out.println("------------------------------");
        arrayListSearch = new BinarySearch<>(arrayList);
        System.out.println("Sorted Binary Search");
        System.out.println("Tim so 100");
        arrayListSearch.getRunningTime(100);
        System.out.println("Tim so 10");
        arrayListSearch.getRunningTime(10);
        System.out.println("Tim so 1");
        arrayListSearch.getRunningTime(1);
    }
}
