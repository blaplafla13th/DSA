package hw4_20001976_PhamBaThang.bai3;

public class Test {
    public static void main(String[] args) {
        QueueInterface<Integer> queue = new ArrayQueue<>(4);
        queue.enqueue(1);
        queue.dequeue();
        System.out.println(queue.isEmpty());
        queue.enqueue(1);
        queue.enqueue(1);
        queue.enqueue(1);
        queue.enqueue(1);
        for (int i : queue) {
            System.out.print(i);
        }
        System.out.println();
        queue = new LinkedListQueue<>();
        queue.enqueue(1);
        queue.dequeue();
        System.out.println(queue.isEmpty());
        queue.enqueue(1);
        queue.enqueue(1);
        queue.enqueue(1);
        for (int i : queue) {
            System.out.print(i);
        }
    }
}
