package hw6_20001976.comparable_sort;
public class BubbleSort<T extends Comparable<? super T>> extends Sort<T> {

    public BubbleSort(T[] array) {
        this.array = array;
    }

    public void sortAsc() {
        if (array == null) throw new IllegalArgumentException();
        swapCounter = 0;
        compareCounter = 0;
        boolean swapped;
        for (int i = 0; i < array.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < array.length - i - 1; j++) {
                compareCounter++;
                if (array[j].compareTo(array[j + 1]) > 0) {
                    swap(j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped)
                break;
        }
    }

    public void sortDesc() {
        if (array == null) throw new IllegalArgumentException();
        swapCounter = 0;
        compareCounter = 0;
        boolean swapped;
        for (int i = 0; i < array.length - 1; i++) {
            swapped = false;

            for (int j = 0; j < array.length - i - 1; j++) {
                compareCounter++;
                if (array[j].compareTo(array[j + 1]) < 0) {
                    swap(j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped)
                break;
        }
    }

    @Override
    public String toString() {
        return "BubbleSort: " + super.getDetail();
    }
}

