package hw7_20001976.node_search;

public abstract class Node<K> {
    protected K key;

    public Node(K k) {
        key = k;
    }

    public K getKey() {
        return key;
    }//K là khóa của phần tử

    public String toString() {
        return key.toString();
    }
}
