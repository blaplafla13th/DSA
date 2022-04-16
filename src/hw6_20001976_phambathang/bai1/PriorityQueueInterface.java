package hw6_20001976_phambathang.bai1;

import java.util.Iterator;

public interface PriorityQueueInterface<K, E> extends Iterable<Entry<K, E>> {
    int size();

    boolean isEmpty();

    void insert(Entry<K, E> entry); //thêm một entry vào PQ

    void insert(K k, E e); //thêm phẩn tử có key k và giá trị e vào PQ

    Entry<K, E> removeMin(); //loại phần tử có giá trị nhỏ nhất

    Entry<K, E> min(); //trả về phần tử có key nhỏ nhất

    Iterator<Entry<K, E>> iterator();
}
