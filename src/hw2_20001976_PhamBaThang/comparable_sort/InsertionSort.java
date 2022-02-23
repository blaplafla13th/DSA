package hw2_20001976_PhamBaThang.comparable_sort;

public class InsertionSort<T extends Comparable<? super T>> extends Sort<T> {

    public InsertionSort(T[] array) {
        this.array = array;
    }

    public void sortAsc(boolean printDetail) {
        swapCounter = 0;
        compareCounter = 0;
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                compareCounter++;
                if (array[j].compareTo(array[j - 1]) < 0) {
                    swap(j, j - 1);
                } else break;
            }
            if (printDetail) {
                printArray();
            }
        }
    }

    public void sortDesc(boolean printDetail) {
        swapCounter = 0;
        compareCounter = 0;
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                compareCounter++;
                if (array[j].compareTo(array[j - 1]) > 0) {
                    swap(j, j - 1);
                } else break;
            }
            if (printDetail) {
                printArray();
            }
        }
    }

}

