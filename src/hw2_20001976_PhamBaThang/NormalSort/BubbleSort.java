package hw2_20001976_PhamBaThang.NormalSort;

public class BubbleSort extends Sort {

    public BubbleSort(int[] array) {
        this.array = array;
        swapCounter = 0;
        compareCounter = 0;
    }

    public void sortAsc(boolean printDetail) {
        swapCounter = 0;
        compareCounter = 0;
        boolean swapped;
        for (int i = 0; i < array.length - 1; i++) {

            swapped = false;

            for (int j = 0; j < array.length - i - 1; j++) {
                compareCounter++;
                if (array[j] > array[j + 1]) {
                    swap(j, j + 1);
                    swapped = true;
                }
            }
            if (printDetail) {
                printArray();
            }
            if (!swapped)
                break;
        }
    }

    public void sortDesc(boolean printDetail) {
        swapCounter = 0;
        compareCounter = 0;
        boolean swapped;
        for (int i = 0; i < array.length - 1; i++) {
            swapped = false;

            for (int j = 0; j < array.length - i - 1; j++) {
                compareCounter++;
                if (array[j] < array[j + 1]) {
                    swap(j, j + 1);
                    swapped = true;
                }
            }
            if (printDetail) {
                printArray();
            }
            if (!swapped)
                break;
        }
    }
}

