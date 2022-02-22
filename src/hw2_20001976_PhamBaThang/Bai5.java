package hw2_20001976_PhamBaThang;

import hw2_20001976_PhamBaThang.comparable_sort.BubbleSort;
import hw2_20001976_PhamBaThang.comparable_sort.InsertionSort;
import hw2_20001976_PhamBaThang.comparable_sort.SelectionSort;
import hw2_20001976_PhamBaThang.comparable_sort.Sort;

public class Bai5 {
    public static void main(String[] args) {
        Character[] unsortedArray = {'s', 'd', 'c', 'a', 'g', 'z'};
        System.out.println("Unsorted Array");
        // y1
        printArray(unsortedArray);
        System.out.println("Bubble sort:");
        Sort<Character> bubbleSort = new BubbleSort<>(unsortedArray.clone());
        bubbleSort.sortAsc(true);
        System.out.println(bubbleSort.getDetail());
        // y2
        System.out.println("Selection sort:");
        Sort<Character> selectionSort = new SelectionSort<>(unsortedArray.clone());
        selectionSort.sortAsc(true);
        System.out.println(selectionSort.getDetail());
        // y3
        System.out.println("Insertion sort:");
        Sort<Character> insertionSort = new InsertionSort<>(unsortedArray.clone());
        insertionSort.sortAsc(true);
        System.out.println(insertionSort.getDetail());

    }

    public static void printArray(Character[] array) {
        System.out.print("Array:");
        for (Character i : array) {
            System.out.print(" " + i);
        }
        System.out.println();
    }
}
