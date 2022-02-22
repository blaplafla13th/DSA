package hw2_20001976_PhamBaThang;

import hw2_20001976_PhamBaThang.NormalSort.BubbleSort;
import hw2_20001976_PhamBaThang.NormalSort.InsertionSort;
import hw2_20001976_PhamBaThang.NormalSort.SelectionSort;
import hw2_20001976_PhamBaThang.NormalSort.Sort;

public class BaiTu1Den4 {
    public static void main(String[] args) {
        int[] unsortedArray = {3, 8, 5, 6, 4, 0, 1, 2, 7, 9};
        System.out.println("Unsorted Array");
        // bai1
        printArray(unsortedArray);
        System.out.println("Bubble sort:");
        Sort bubbleSort = new BubbleSort(unsortedArray.clone());
        bubbleSort.sortAsc(true);
        System.out.println(bubbleSort.getDetail());
        // bai2
        System.out.println("Selection sort:");
        Sort selectionSort = new SelectionSort(unsortedArray.clone());
        selectionSort.sortAsc(true);
        System.out.println(selectionSort.getDetail());
        // bai3
        System.out.println("Insertion sort:");
        Sort insertionSort = new InsertionSort(unsortedArray.clone());
        insertionSort.sortAsc(true);
        System.out.println(insertionSort.getDetail());
        //bai4
        int[] sortedArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("Sorted Array");
        // y1
        printArray(sortedArray);
        System.out.println("Bubble sort:");
        bubbleSort = new BubbleSort(sortedArray.clone());
        bubbleSort.sortAsc(false);
        System.out.println(bubbleSort.getDetail());
        // y2
        System.out.println("Selection sort:");
        selectionSort = new SelectionSort(sortedArray.clone());
        selectionSort.sortAsc(false);
        System.out.println(selectionSort.getDetail());
        // y3
        System.out.println("Insertion sort:");
        insertionSort = new InsertionSort(sortedArray.clone());
        insertionSort.sortAsc(false);
        System.out.println(insertionSort.getDetail());

    }

    public static void printArray(int[] array) {
        System.out.print("Array:");
        for (int i : array) {
            System.out.print(" " + i);
        }
        System.out.println();
    }
}
