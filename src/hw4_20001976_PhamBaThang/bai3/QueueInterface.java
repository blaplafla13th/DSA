package hw4_20001976_PhamBaThang.bai3;

public interface QueueInterface<E> extends Iterable<E> {
    void enqueue(E element);

    E dequeue();

    boolean isEmpty();
}