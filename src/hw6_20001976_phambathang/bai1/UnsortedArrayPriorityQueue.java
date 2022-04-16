package hw6_20001976_phambathang.bai1;

import java.util.Iterator;

@SuppressWarnings("unchecked,rawtypes")
public class UnsortedArrayPriorityQueue<K extends Comparable, E> implements PriorityQueueInterface<K, E> {
    ArrEntry[] array;
    int n = 0;
    int defaultsize = 1000;

    public UnsortedArrayPriorityQueue(int defaultsize) {
        this.defaultsize = defaultsize;
        array = new UnsortedArrayPriorityQueue.ArrEntry[defaultsize];
    }

    public UnsortedArrayPriorityQueue() {
        array = new UnsortedArrayPriorityQueue.ArrEntry[defaultsize];
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public void insert(Entry<K, E> entry) {
        if (n < defaultsize)
            array[n++] = (ArrEntry) entry;
        else
            System.out.println("Out of index");
    }

    @Override
    public void insert(K k, E e) {
        insert(new ArrEntry(k, e));
    }

    @Override
    public Entry removeMin() {
        Entry<K, E> min = min();
        boolean found = false;
        if (min != null) {
            for (int i = 0; i < n; i++) {
                if (found && i + 1 < array.length)
                    array[i] = array[i + 1];
                else if (array[i] == min) {
                    if (i + 1 < array.length)
                        array[i] = array[i + 1];
                    n--;
                    found = true;
                }
            }
        }
        return min;
    }

    @Override
    public Entry min() {
        if (isEmpty())
            return null;
        else {
            Entry<K, E> min = array[0];
            for (int i = 1; i < n; i++) {
                if (array[i] != null && min.getKey().compareTo(array[i].getKey()) > 0)
                    min = array[i];
            }
            return min;
        }
    }

    public Iterator<Entry<K, E>> iterator() {
        return new Iter();
    }

    protected class ArrEntry extends Entry<K, E> {
        public ArrEntry(K k, E e) {
            super(k, e);
        }
    }

    protected class Iter implements Iterator<Entry<K, E>> {
        int num = 0;

        @Override
        public boolean hasNext() {
            return num < n;
        }

        @Override
        public Entry<K, E> next() {
            return array[num++];
        }
    }
}
