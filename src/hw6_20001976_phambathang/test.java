package hw6_20001976_phambathang;

import hw6_20001976_phambathang.comparable_sort.HeapSort;
import hw6_20001976_phambathang.comparable_sort.Sort;


public class test {
    public static void main(String[] args) {
        Integer[] arr = {13, 5, 8, 7, 2};
        Sort<Integer> s = new HeapSort<>(arr);
        s.calcTimeSortDesc();
        System.out.println(s);
        s.printArray();
    }
}
