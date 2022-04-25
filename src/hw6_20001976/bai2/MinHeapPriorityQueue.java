package hw6_20001976.bai2;

import hw6_20001976.bai1.Entry;
import hw6_20001976.bai1.SortedArrayPriorityQueue;

import java.util.Iterator;

@SuppressWarnings("StatementWithEmptyBody,uncheck,rawtypes")
public class MinHeapPriorityQueue<K extends Comparable, E> extends SortedArrayPriorityQueue<K, E> {
    protected ArrEntry[] heapPQ = array;

    //Các phương thức bổ sung
    public MinHeapPriorityQueue(int defaultSize) {
        super(defaultSize);
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

    private void swap(int i, int j) {
        if (i == j || i > n || j > n || i < 0 || j < 0) ;
        else {
            ArrEntry temp = heapPQ[i];
            heapPQ[i] = heapPQ[j];
            heapPQ[j] = temp;
        }
    }

    @Override
    public void insert(Entry<K, E> entry) {
        if (entry == null) {
            System.out.println("Null Element");
            return;
        }
        array[n++] = (ArrEntry) entry;
        upHeap();
    }

    @Override
    public Entry<K, E> removeMin() {
        swap(0, n - 1);
        n--;
        downHeap();
        return heapPQ[n];
    }

    @Override
    public Entry<K, E> min() {
        return heapPQ[0];
    }

    //vun len
    protected void upHeap() {
        int index = n - 1;
        while (heapPQ[index].compareTo(heapPQ[parent(index)]) <= 0) {
            swap(index, parent(index));
            index = parent(index);
            if (index == 0)
                break;
        }
    }

    //vun xuong
    protected void downHeap() {
        int i = 0;
        while (i < n) {
            if (right(i) < n) {
                int min = i;
                if (heapPQ[min].compareTo(heapPQ[left(i)]) >= 0) {
                    min = left(i);
                }
                if (heapPQ[min].compareTo(heapPQ[right(i)]) >= 0)
                    min = right(i);
                if (min != i) {
                    swap(min, i);
                    i = min;
                }
            } else if (left(i) < n && (heapPQ[i].compareTo(heapPQ[left(i)]) >= 0)) {
                swap(i, left(i));
            }
            break;
        }
    }

    @Override
    public Iterator<Entry<K, E>> iterator() {
        return super.iterator();
    }
}
