package hw6_20001976_phambathang.comparable_sort;

public class HeapSort<T extends Comparable> extends Sort<T> {

    public HeapSort(T[] array) {
        this.array = array;
    }

    @Override
    public void sortAsc(boolean printDetail) {
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            upHeap(i);
            if (printDetail) {
                printArray();
            }
        }
    }

    private void upHeap(int parent) {
        if (parent > array.length || parent < 0) {
            return;
        }
        int largest = parent;
        int left = 2 * parent + 1;
        int right = 2 * parent + 2;
        // find largest
        compareCounter += 1;
        if (left < array.length/*if have left child*/ && array[left].compareTo(array[largest]) > 0)
            largest = left;
        compareCounter += 1;
        if (right < array.length/*if have right child*/ && array[right].compareTo(array[largest]) > 0)
            largest = right;
        compareCounter += 1;
        if (largest != parent) {
            swap(parent, largest);
            upHeap(largest);//goi xuong cay con
        }
    }

    @Override
    public void sortDesc(boolean printDetail) {
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            downHeap(i);
            if (printDetail) {
                printArray();
            }
        }
    }

    private void downHeap(int parent) {
        if (parent > array.length || parent < 0) {
            return;
        }
        int smallest = parent;
        int left = 2 * parent + 1;
        int right = 2 * parent + 2;
        // find smallest
        compareCounter += 1;
        if (left < array.length/*if have left child*/ && array[left].compareTo(array[smallest]) < 0)
            smallest = left;
        compareCounter += 1;
        if (right < array.length/*if have right child*/ && array[right].compareTo(array[smallest]) < 0)
            smallest = right;
        compareCounter += 1;
        if (smallest != parent) {
            swap(parent, smallest);
            downHeap(smallest);//goi xuong cay con
        }
    }

    @Override
    public String toString() {
        return "HeapSort: " + super.getDetail();
    }
}
