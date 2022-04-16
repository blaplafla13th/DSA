package hw6_20001976_phambathang.bai1;

import java.util.ArrayList;
import java.util.Iterator;

@SuppressWarnings("unchecked,rawtypes")
public class UnsortedLinkedPriorityQueue<K extends Comparable, E> implements PriorityQueueInterface<K, E> {
    int n = 0;
    private NodeEntry head;
    private NodeEntry tail;
    private ArrayList<NodeEntry> store; //luu vo mot mang de insert node don gian hon

    public UnsortedLinkedPriorityQueue() {
        head = null;
        tail = null;
        store = new ArrayList<>();
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
        if (entry == null) {
            System.out.println("Null Element");
            return;
        }
        store.add((NodeEntry) entry);
        int parent = n % 2 == 0 ? (n - 1) / 2/*(parent of right child)*/ : n / 2/*(parent of left child)*/;
        tail = store.get(n);
        if (store.size() == 1) {
            head = store.get(0);
        } else {
            tail.parent = store.get(parent);
            if (n % 2 == 0)
                tail.parent.right = tail;
            else
                tail.parent.left = tail;
        }
        n++;
    }

    @Override
    public void insert(K k, E e) {
        insert(new NodeEntry(k, e));
    }

    @Override
    public Entry<K, E> removeMin() {
        Entry min = min();
        if (min == null) {
            return null;
        }
        if (min == tail) {
            //TODO: remove tail
        } else {
            //TODO: tail to min
        }
        n--;
        return min;
    }

    @Override
    public Entry<K, E> min() {
        if (isEmpty())
            return null;
        Entry min = store.get(0);
        for (Entry<K, E> entry : store) {
            if (entry.getKey().compareTo(min.getKey()) < 0)
                min = entry;
        }
        return min;
    }

    @Override
    public Iterator<Entry<K, E>> iterator() {
        return new Iter();
    }

    protected class NodeEntry extends Entry<K, E> {
        private NodeEntry parent;
        private NodeEntry left;
        private NodeEntry right;

        public NodeEntry(K k, E e) {
            super(k, e);
        }
    }

    private class Iter implements Iterator<Entry<K, E>> {
        int count = 0;

        @Override
        public boolean hasNext() {
            return count < n;
        }

        @Override
        public Entry<K, E> next() {
            return store.get(count);
        }
    }
}
