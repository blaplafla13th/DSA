package hw6_20001976_phambathang.bai1;


import java.util.Iterator;

@SuppressWarnings("unchecked,rawtypes")
public class UnsortedLinkedPriorityQueue<K extends Comparable, E> implements PriorityQueueInterface<K, E> {
    int n = 0;
    private NodeEntry head;
    private NodeEntry tail;

    public UnsortedLinkedPriorityQueue() {
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
        if (n == 0) {
            head = (NodeEntry) entry;
        } else {
            tail.next = (NodeEntry) entry;
        }
        tail = (NodeEntry) entry;
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
            System.out.println("Empty");
            return null;
        }
        if (min == head) {
            head = head.next;
        } else {
            NodeEntry temp = head;
            while (temp.next != null) {
                if (temp.next == min) {
                    temp.next = temp.next.next;
                    break;
                }
            }
        }
        n--;
        return min;
    }

    @Override
    public Entry<K, E> min() {
        if (isEmpty())
            return null;
        Entry min = head;
        for (Entry<K, E> entry : this) {
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
        private NodeEntry next;

        public NodeEntry(K k, E e) {
            super(k, e);
        }
    }

    private class Iter implements Iterator<Entry<K, E>> {
        NodeEntry pointer = head;
        int count = 0;

        @Override
        public boolean hasNext() {
            return count < n;
        }

        @Override
        public Entry<K, E> next() {
            NodeEntry temp = pointer;
            count++;
            pointer = pointer.next;
            return temp;
        }
    }
}
