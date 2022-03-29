package hw4_20001976.bai3;

import java.util.Iterator;

@SuppressWarnings("unchecked")
public class LinkedListQueue<E> implements QueueInterface<E> {
    private Node top = null;
    private Node bot = null;

    @Override
    public void enqueue(E element) {
        if (top == null)
            bot = top = new Node(element);
        else
            bot = bot.next = new Node(element);
    }

    @Override
    public E dequeue() {
        if (top == null)
            throw new IndexOutOfBoundsException();
        E result = top.element;
        if (top.next == null)
            top = bot = null;
        else top = top.next;
        return result;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
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
        private Node currentNode = top;

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
