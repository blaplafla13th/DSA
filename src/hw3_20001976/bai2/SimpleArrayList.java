package hw3_20001976.bai2;

import java.util.Arrays;
import java.util.Iterator;
@SuppressWarnings({"unchecked"})
public class SimpleArrayList<T> implements ListInterface<T> {
    private final int defaultSize = 100;
    private transient T[] array;
    private int n = 0;

    public SimpleArrayList() {
        array = (T[]) new Object[defaultSize];
    }

    public SimpleArrayList(int capacity) {
        if (capacity > 0)
            array = (T[]) new Object[capacity];
        else
            throw new IllegalArgumentException("Illegal Capacity: " + capacity);
    }

    @Override
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

    @Override
    public T get(int i) {
        if (array == null) {
            throw new NullPointerException();
        } else if (i < 0 || i > n) throw new IndexOutOfBoundsException();
        return array[i];
    }

    @Override
    public void set(int i, T data) {
        if (array == null) {
            throw new NullPointerException();
        }
        if (i < 0 || i > n) throw new IndexOutOfBoundsException();
        array[i] = data;
    }

    @Override
    public void remove(T data) {
        int index = 0;
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

    @Override
    public boolean isContain(T data) {
        if (array == null) {
            throw new NullPointerException();
        } else if (data == null) {
            for (int i = 0; i < n; i++) {
                if (array[i] == null) {
                    return true;
                }
            }
        } else {
            for (int i = 0; i < n; i++) {
                if (array[i] != null && array[i].equals(data)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int indexOf(T data) {
        if (data == null) {
            for (int i = 0; i < n; i++) {
                if (array[i] == null) return i;
            }
        } else if (isContain(data)) {
            for (int i = 0; i < n; i++) {
                if (array[i] != null && array[i].equals(data)) {
                    return i;
                }
            }
        }
        return -1;
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
    public Iterator<T> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<T> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < n;
        }

        @Override
        public T next() {
            return array[currentIndex++];
        }
    }
}
