package hw7_20001976.bai1;

import java.util.Arrays;
import java.util.Iterator;

@SuppressWarnings({"unchecked"})
public class SimpleArrayList<T> implements Iterable<T> {
    private final int DEFAULT_SIZE = 100;
    private transient T[] array;
    private int n = 0;

    public SimpleArrayList() {
        array = (T[]) new Object[DEFAULT_SIZE];
    }

    public SimpleArrayList(T[] array) {
        this.array = array;
    }

    public SimpleArrayList(int capacity) {
        if (capacity > 0)
            array = (T[]) new Object[capacity];
        else
            throw new IllegalArgumentException("Illegal Capacity: " + capacity);
    }

    public void add(T data) {
        if (array == null) {
            array = (T[]) new Object[0];
        }
        if (n >= array.length) {
            array = Arrays.copyOf(array, array.length * 3 / 2);
        }
        array[n] = data;
        n++;
    }

    public T get(int i) {
        if (array == null) {
            throw new NullPointerException();
        } else if (i < 0 || i > n) throw new IndexOutOfBoundsException();
        return array[i];
    }

    public void set(int i, T data) {
        if (array == null) {
            throw new NullPointerException();
        }
        if (i < 0 || i > n) throw new IndexOutOfBoundsException();
        array[i] = data;
    }

    public void remove(T data) {
        T[] newArray = (T[]) new Object[n];
        if (array == null) {
            throw new NullPointerException();
        } else if (data == null) {
            for (int i = 0; i < n; i++) {
                if (array[i] == null) {
                    n--;
                    for (int j = 0; j < n + 1; j++) {
                        if (i != j) {
                            newArray[j] = array[i];
                        }
                    }
                    break;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (array[i] != null && array[i].equals(data)) {
                n--;
                for (int j = 0; j < n + 1; j++) {
                    if (i != j) {
                        newArray[j] = array[i];
                    }
                }
                break;
            }
        }
        array = newArray;
    }

    public int size() {
        return n;
    }


    public boolean isEmpty() {
        return n == 0;
    }


    public Iterator<T> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<T> {
        private int currentIndex = 0;

        public boolean hasNext() {
            return currentIndex < n;
        }

        public T next() {
            return array[currentIndex++];
        }
    }
}
