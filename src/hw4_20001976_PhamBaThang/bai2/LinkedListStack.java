package hw4_20001976_PhamBaThang.bai2;

import java.util.EmptyStackException;
import java.util.Iterator;

@SuppressWarnings("unchecked")
public class LinkedListStack<E> implements StackInterface<E> {
    private Node stack = null;

    @Override
    public void push(E element) {
        if (stack == null)
            stack = new Node(element);
        else
            stack = new Node(element, stack);
    }

    @Override
    public E pop() {
        if (stack == null)
            throw new EmptyStackException();
        E result = stack.element;
        if (stack.next == null)
            stack = null;
        else stack = stack.next;
        return result;
    }

    @Override
    public boolean isEmpty() {
        return stack == null;
    }

    @Override
    public E top() {
        if (stack == null)
            throw new EmptyStackException();
        return stack.element;
    }

    @Override
    public Iterator<E> iterator() {
        return new StackIterator<>();
    }

    class Node {
        E element;
        Node next;

        public Node(E element) {
            this.element = element;
        }

        public Node(E element, Node next) {
            this.element = element;
            this.next = next;
        }
    }

    private class StackIterator<E> implements Iterator<E> {
        private Node currentNode = stack;

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public E next() {
            E data = (E) currentNode.element;
            currentNode = currentNode.next;
            return data;

        }
    }
}
