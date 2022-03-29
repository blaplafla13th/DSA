package hw4_20001976.bai3;

import java.util.Iterator;

@SuppressWarnings("unchecked")

public class ArrayQueue<E> implements QueueInterface<E> {
    private static final int DEFAULT_SIZE = 100;
    private final int n;
    private E[] queue;
    private int top = 0;
    private int count = 0;

    public ArrayQueue(int capacity) {
        n = capacity;
        queue = (E[]) new Object[capacity];
    }

    public ArrayQueue() {
        n = DEFAULT_SIZE;
        queue = (E[]) new Object[DEFAULT_SIZE];
    }

    @Override
    public void enqueue(E element) {
        if (count + 1 > queue.length)
            throw new IndexOutOfBoundsException();
        queue[(top + count) % n] = element;
        count++;
    }

    @Override
    public E dequeue() {
        E result = queue[top];
        top = (++top) % n;
        count--;
        return result;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayQueueIterator();
    }

    class ArrayQueueIterator implements Iterator<E> {
        private int current = top;
        private int num = 0;

        @Override
        public boolean hasNext() {
            return num < count;
        }

        @Override
        public E next() {
            E data = queue[(current + num) % n];
            num++;
            return data;
        }
    }
}

