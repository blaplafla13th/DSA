package hw2_20001976_PhamBaThang.normal_sort;

public class InsertionSort extends Sort {

    public InsertionSort(int[] array) {
        this.array = array;
    }

    public void sortAsc(boolean printDetail) {
        if (array == null) throw new IllegalArgumentException();
        swapCounter = 0;
        compareCounter = 0;
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                compareCounter++;
                if (array[j] < array[j - 1]) {
                    swap(j, j - 1);
                } else break;
            }
            if (printDetail) {
                printArray();
            }
        }
    }

    public void sortDesc(boolean printDetail) {
        if (array == null) throw new IllegalArgumentException();
        swapCounter = 0;
        compareCounter = 0;
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                compareCounter++;
                if (array[j] > array[j - 1]) {
                    swap(j, j - 1);
                } else break;
            }
            if (printDetail) {
                printArray();
            }
        }
    }

}

