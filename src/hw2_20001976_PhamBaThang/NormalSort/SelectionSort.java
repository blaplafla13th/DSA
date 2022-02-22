package hw2_20001976_PhamBaThang.NormalSort;

public class SelectionSort extends Sort {

    public SelectionSort(int[] array) {
        this.array = array;
        swapCounter = 0;
        compareCounter = 0;
    }

    public void sortAsc(boolean printDetail) {
        swapCounter = 0;
        compareCounter = 0;
        for (int i = 0; i < array.length - 1; i++) {
            int min_index = i;
            for (int j = i + 1; j < array.length; j++) {
                compareCounter++;
                if (array[j] < array[min_index])
                    min_index = j;
            }
            swap(i, min_index);
            if (printDetail) {
                printArray();
            }
        }
    }

    public void sortDesc(boolean printDetail) {
        swapCounter = 0;
        compareCounter = 0;
        for (int i = 0; i < array.length - 1; i++) {
            int max_index = i;
            for (int j = i + 1; j < array.length; j++) {
                compareCounter++;
                if (array[j] > array[max_index])
                    max_index = j;
            }
            swap(i, max_index);
            if (printDetail) {
                printArray();
            }
        }
    }

}

