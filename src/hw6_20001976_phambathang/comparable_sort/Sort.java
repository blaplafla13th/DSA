package hw6_20001976_phambathang.comparable_sort;

public abstract class Sort<T extends Comparable> {
    protected int swapCounter = 0;
    protected int compareCounter = 0;
    protected T[] array;
    private long time = 0;

    public T[] getArray() {
        return array;
    }

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

    public long calcTimeSortAsc(boolean printDetail) {
        this.time = System.nanoTime();
        sortAsc(printDetail);
        this.time = (System.nanoTime() - time);
        return time;
    }

    public long calcTimeSortDesc(boolean printDetail) {
        this.time = System.nanoTime();
        sortDesc(printDetail);
        this.time = (System.nanoTime() - time);
        return time;
    }

    public abstract void sortAsc(boolean printDetail);

    public abstract void sortDesc(boolean printDetail);

    public String getDetail() {
        if (compareCounter == 0)
            return "chua sap xep";
        else if (time == 0)
            return String.format("So lan so sanh: %d, so lan doi cho: %d "
                    , compareCounter, swapCounter);
        else
            return String.format("So lan so sanh: %d, so lan doi cho: %d , mat: %.3f ms"
                    , compareCounter, swapCounter, time / 1000000.0);
    }
}
