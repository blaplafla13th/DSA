package hw6_20001976.comparable_sort;

public class InsertionSort<T extends Comparable<? super T>> extends Sort<T> {

    public InsertionSort(T[] array) {
        this.array = array;
    }

    public void sortAsc() {
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
        }
    }

    public void sortDesc() {
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
        }
    }

    @Override
    public String toString() {
        return "InsertionSort: " + super.getDetail();
    }
}

