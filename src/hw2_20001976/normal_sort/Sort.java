package hw2_20001976.normal_sort;

public abstract class Sort {
    protected int swapCounter = 0;
    protected int compareCounter = 0;
    protected int[] array;

    public int getSwapCounter() {
        return swapCounter;
    }

    public int getCompareCounter() {
        return compareCounter;
    }

    public void printArray() {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public void swap(int indexA, int indexB) {
        if (array == null) throw new IllegalArgumentException();
        if (indexA == indexB) return;
        int temp = array[indexA];
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
