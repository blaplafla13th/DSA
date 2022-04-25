package hw6_20001976.bai1;

import java.util.Iterator;

@SuppressWarnings("unchecked,rawtypes")
public class SortedArrayPriorityQueue<K extends Comparable, E> implements PriorityQueueInterface<K, E> {
    final int DEFAULT_SIZE = 1000;
    protected ArrEntry[] array;
    protected int n = 0;
    int start = 0;

    public SortedArrayPriorityQueue(int defaultSize) {
        array = new SortedArrayPriorityQueue.ArrEntry[defaultSize];
    }

    public SortedArrayPriorityQueue() {
        array = new SortedArrayPriorityQueue.ArrEntry[DEFAULT_SIZE];
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
        if (n == array.length)
            System.out.println("Full");
        else if (entry == null) {
            System.out.println("Null Element");
        } else if (isEmpty()) {
            array[0] = (ArrEntry) entry;
            start = 0;
            n++;
        } else {
            boolean found = false;
            ArrEntry in = (ArrEntry) entry;
            for (int k = 0; k < n; k++) {
                int i = (k + start) % array.length;
                if (in.compareTo(array[i]) <= 0) {
                    ArrEntry temp = array[i];
                    array[i] = (ArrEntry) entry;
                    entry = temp;
                    found = true;
                    n++;
                    for (int l = k + 1; l < n; l++) {
                        int j = (l + start) % array.length;
                        array[j] = (ArrEntry) entry;
                        if (j + 1 < n)
                            temp = array[j + 1];
                        entry = temp;
                    }
                    break;
                }
            }
            if (!found) {
                array[(n + start) % array.length] = (ArrEntry) entry;
                n++;
            }
        }
    }

    @Override
    public void insert(K k, E e) {
        insert(new ArrEntry(k, e));
    }

    @Override
    public Entry<K, E> removeMin() {
        Entry result = array[start];
        n--;
        start = start + 1 % array.length;
        return result;
    }

    @Override
    public Entry<K, E> min() {
        return array[start];
    }

    public Iterator<Entry<K, E>> iterator() {
        return new Iter();
    }

    protected class ArrEntry extends Entry<K, E> {
        public ArrEntry(K k, E e) {
            super(k, e);
        }

        public int compareTo(ArrEntry o) {
            return this.getKey().compareTo(o.getKey());
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
            Entry<K, E> result = array[(start + num) % array.length];
            num++;
            return result;
        }
    }
}
