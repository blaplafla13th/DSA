package hw6_20001976_phambathang.comparable_sort;

public class InsertionSort<T extends Comparable> extends Sort<T> {

    public InsertionSort(T[] array) {
        this.array = array;
    }

    public void sortAsc(boolean printDetail) {
        if (array == null) throw new IllegalArgumentException();
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
        if (array == null) throw new IllegalArgumentException();
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

    @Override
    public String toString() {
        return "InsertionSort: " + super.getDetail();
    }
}

