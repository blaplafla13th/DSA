package hw6_20001976_phambathang.comparable_sort;

@SuppressWarnings("unchecked")
public class HeapSort<T extends Comparable<? super T>> extends Sort<T> {

    private T[] heapPQ;
    private int n = 0;

    public HeapSort(T[] array) {
        this.array = array;
        heapPQ = (T[]) new Comparable[array.length];
    }

    private int parent(int i) {
        return i % 2 == 0 ? (i - 1) / 2/*(parent of right child)*/ : i / 2/*(parent of left child)*/;
    }

    private int right(int i) {
        return 2 * i + 2;
    }

    private int left(int i) {
        return 2 * i + 1;
    }

    private void swapPQ(int i, int j) {
        if (i == j || i > n || j > n || i < 0 || j < 0) ;
        else {
            swapCounter++;
            T temp = heapPQ[i];
            heapPQ[i] = heapPQ[j];
            heapPQ[j] = temp;
        }
    }

    @Override
    public void sortAsc(boolean printDetail) {
        swapCounter = 0;
        compareCounter = 0;
        for (T data : array) {
            heapPQ[n++] = data;
            int index = n - 1;
            compareCounter++;
            while (heapPQ[index].compareTo(heapPQ[parent(index)]) <= 0) {
                compareCounter++;
                swapPQ(index, parent(index));
                index = parent(index);
                if (index == 0)
                    break;
            }
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = removeMin();
        }
    }

    public T removeMin() {
        swapPQ(0, n - 1);
        n--;
        int i = 0;
        while (i < n) {
            compareCounter++;
            if (right(i) < n) {
                compareCounter++;
                if (heapPQ[i].compareTo(heapPQ[left(i)]) <= 0
                        && heapPQ[i].compareTo(heapPQ[right(i)]) <= 0)
                    break;
                else if (heapPQ[i].compareTo(heapPQ[left(i)]) > 0) {
                    compareCounter++;
                    swapPQ(i, left(i));
                    i = left(i);
                } else if (heapPQ[i].compareTo(heapPQ[right(i)]) > 0) {
                    compareCounter += 2;
                    swapPQ(i, right(i));
                    i = right(i);
                }
            } else if (left(i) < n && (heapPQ[i].compareTo(heapPQ[left(i)]) >= 0)) {
                swapPQ(i, left(i));
                compareCounter++;
            }
            break;
        }
        return heapPQ[n];
    }

    @Override
    public void sortDesc(boolean printDetail) {
        swapCounter = 0;
        compareCounter = 0;
        for (T data : array) {
            heapPQ[n++] = data;
            int index = n - 1;
            compareCounter++;
            while (heapPQ[index].compareTo(heapPQ[parent(index)]) >= 0) {
                compareCounter++;
                swapPQ(index, parent(index));
                index = parent(index);
                if (index == 0)
                    break;
            }
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = removeMax();
        }
    }

    public T removeMax() {
        swapPQ(0, n - 1);
        n--;
        int i = 0;
        while (i < n) {
            compareCounter++;
            if (right(i) < n) {
                compareCounter++;
                if (heapPQ[i].compareTo(heapPQ[left(i)]) >= 0
                        && heapPQ[i].compareTo(heapPQ[right(i)]) >= 0)
                    break;
                else if (heapPQ[i].compareTo(heapPQ[left(i)]) < 0) {
                    compareCounter++;
                    swapPQ(i, left(i));
                    i = left(i);
                } else if (heapPQ[i].compareTo(heapPQ[right(i)]) < 0) {
                    compareCounter += 2;
                    swapPQ(i, right(i));
                    i = right(i);
                }
            } else if (left(i) < n && (heapPQ[i].compareTo(heapPQ[left(i)]) <= 0)) {
                swapPQ(i, left(i));
                compareCounter++;
            }
            break;
        }
        return heapPQ[n];
    }

    @Override
    public String toString() {
        return "HeapSort: " + super.getDetail();
    }
}
