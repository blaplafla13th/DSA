package hw6_20001976.comparable_sort;

public class HeapSortTest {
    public static void main(String[] args) {
        Integer[] arr = {13, 5, 8, 7, 2, 7};
        Sort<Integer> s = new HeapSort<>(arr.clone());
        s.calcTimeSortAsc();
        System.out.println(s);
        s.printArray();
        s = new HeapSort<>(arr.clone());
        s.calcTimeSortDesc();
        System.out.println(s);
        s.printArray();
    }
}
