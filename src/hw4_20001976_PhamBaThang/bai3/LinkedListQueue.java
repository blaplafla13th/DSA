package hw4_20001976_PhamBaThang.bai3;

import java.util.Iterator;

@SuppressWarnings("unchecked")
public class LinkedListQueue<E> implements QueueInterface<E> {
    private Node queue = null;

    @Override
    public void enqueue(E element) {
        if (queue == null)
            queue = new Node(element);
        else
            queue = new Node(element, queue);
    }

    @Override
    public E dequeue() {
        if (queue == null)
            throw new IndexOutOfBoundsException();
        E result = queue.element;
        queue = queue.next;
        return result;
    }

    @Override
    public boolean isEmpty() {
        return queue == null;
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
        private Node currentNode = queue;

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
