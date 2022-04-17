package hw6_20001976_phambathang.bai1;

public abstract class Entry<K, E> {
    protected K key;
    protected E element;

    public Entry(K k, E e) {
        key = k;
        element = e;
    }

    public K getKey() {
        return key;
    }//K là khóa của phần tử

    public E getValue() {
        return element;
    }//E là giá trị phần tử

    public String toString() {
        return (getKey() + " : " + getValue());
    }
}
