package hw6_20001976_phambathang;

import hw6_20001976_phambathang.comparable_sort.HeapSort;
import hw6_20001976_phambathang.comparable_sort.Sort;

public class test {
    public static void main(String[] args) {
        Integer[] arr = {12, 11, 13, 5, 6, 7};
        Sort<Integer> s = new HeapSort<>(arr);
        s.calcTimeSortAsc(false);
        System.out.println(s);
        s.printArray();
    }
}
