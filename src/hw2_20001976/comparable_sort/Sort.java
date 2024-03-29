package hw2_20001976.comparable_sort;

public abstract class Sort<T extends Comparable<? super T>> {
    protected int swapCounter = 0;
    protected int compareCounter = 0;
    protected T[] array;

    public int getSwapCounter() {
        return swapCounter;
    }

    public int getCompareCounter() {
        return compareCounter;
    }

    public void printArray() {
        for (T i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public void swap(int indexA, int indexB) {
        if (array == null) throw new IllegalArgumentException();
        if (indexA == indexB) return;
        T temp = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = temp;
        swapCounter++;
    }

    public abstract void sortAsc(boolean printDetail);

    public abstract void sortDesc(boolean printDetail);

    public String getDetail() {
        return "So lan so sanh: " + compareCounter + ", so lan doi cho: " + swapCounter;
    }
}
