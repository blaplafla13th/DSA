package hw6_20001976.bai1;

import java.util.Iterator;

@SuppressWarnings("unchecked,rawtypes")
public class SortedLinkedPriorityQueue<K extends Comparable, E> implements PriorityQueueInterface<K, E> {
    int n = 0;
    private NodeEntry head;
    private NodeEntry tail;

    public SortedLinkedPriorityQueue() {
    }

    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public void insert(Entry entry) {
        if (entry == null) {
            System.out.println("Null Element");
            return;
        }
        boolean inserted = false;
        if (n == 0) {
            tail = head = (NodeEntry) entry;
        } else {
            NodeEntry in = (NodeEntry) entry;
            if (in.getKey().compareTo(head.getKey()) <= 0) {
                in.next = head;
                head.prev = in;
                head = in;
            } else {
                NodeEntry temp = head.next;
                while (temp != null) {
                    if (in.getKey().compareTo(temp.getKey()) <= 0) {
                        in.prev = temp.prev;
                        in.next = temp;
                        temp.prev.next = (NodeEntry) entry;
                        temp.prev = (NodeEntry) entry;
                        inserted = true;
                        break;
                    }
                    temp = temp.next;
                }
                if (!inserted) {
                    temp = in;
                    tail.next = temp;
                    temp.prev = tail;
                    tail = temp;
                }
            }
        }
        n++;
    }

    @Override
    public void insert(K k, E e) {
        insert(new NodeEntry(k, e));
    }

    @Override
    public Entry<K, E> removeMin() {
        Entry min = head;
        if (min == null) {
            System.out.println("Empty");
            return null;
        }
        head = head.next;
        n--;
        return min;
    }

    @Override
    public Entry<K, E> min() {
        if (isEmpty())
            return null;
        return head;
    }

    @Override
    public Iterator<Entry<K, E>> iterator() {
        return new Iter();
    }

    protected class NodeEntry extends Entry<K, E> {
        private NodeEntry next;
        private NodeEntry prev;

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

