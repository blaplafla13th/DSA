package hw4_20001976.bai2;

import java.util.EmptyStackException;
import java.util.Iterator;

@SuppressWarnings("unchecked")
public class ArrayStack<E> implements StackInterface<E> {
    private static final int DEFAULT_CAPACITY = 100;
    private E[] data;
    private int elementCount = 0;

    public ArrayStack(int capacity) {
        this.data = (E[]) new Object[capacity];
    }

    public ArrayStack() {
        this.data = (E[]) new Object[DEFAULT_CAPACITY];
    }

    @Override
    public void push(E element) {
        if (elementCount + 1 == data.length)
            throw new IndexOutOfBoundsException();
        data[elementCount++] = element;
    }

    @Override
    public E pop() {
        if (elementCount == 0)
            throw new EmptyStackException();
        return data[--elementCount];
    }

    @Override
    public boolean isEmpty() {
        return elementCount == 0;
    }

    @Override
    public E top() {
        if (elementCount == 0)
            throw new EmptyStackException();
        return data[elementCount - 1];
    }

    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<E> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < elementCount;
        }

        @Override
        public E next() {
            return data[currentIndex++];
        }
    }
}
