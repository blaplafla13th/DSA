package hw6_20001976_phambathang.bai1;

import java.util.Iterator;

@SuppressWarnings("unchecked,rawtypes")
public class SortedLinkedPriorityQueue<K extends Comparable, E> implements PriorityQueueInterface {
    int n = 0;
    private NodeEntry head;
    private NodeEntry tail;

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void insert(Entry entry) {

    }

    @Override
    public void insert(Object o, Object o2) {

    }

    @Override
    public Entry removeMin() {
        return null;
    }

    @Override
    public Entry min() {
        return null;
    }

    @Override
    public Iterator<Entry<K, E>> iterator() {
        return null;
    }

    protected class NodeEntry extends Entry<K, E> {
        public NodeEntry(K k, E e) {
            super(k, e);
        }
    }
}
