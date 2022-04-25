package hw7_20001976.node_search;

public class LinearSearch<K> extends Search<K> {
    private LinkedNode<K> first;
    private LinkedNode<K> last;

    @Override
    Node<K> insert(K key) {
        LinkedNode<K> temp = new LinkedNode<>(key);
        if (size == 0)
            first = temp;
        else last.next = temp;
        last = temp;
        size++;
        return temp;
    }

    @Override
    boolean isContain(K data) {
        LinkedNode<K> temp = first;
        while (temp != null) {
            if (temp.getKey().equals(data)) {
                return true;
            } else temp = temp.next;
        }
        return false;
    }

    @Override
    Node<K> getItem(K data) {
        LinkedNode<K> temp = first;
        while (temp != null) {
            if (temp.getKey().equals(data)) {
                return temp;
            } else temp = temp.next;
        }
        return null;
    }

    public class LinkedNode<K> extends Node<K> {
        private LinkedNode<K> next;

        public LinkedNode(K k) {
            super(k);
        }
    }
}
