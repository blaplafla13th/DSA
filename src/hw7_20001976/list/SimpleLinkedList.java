package hw7_20001976.list;

import java.util.Iterator;

public class SimpleLinkedList<T> implements Iterable<T> {
    private Node top = null;
    private Node bot = null;
    private int n = 0;

    public void add(T data) {
        // Thêm phần tử vào đầu danh sách
        if (n == 0) {
            top = new Node(data);
            bot = top;
        } else {
            if (n == 1)
                bot = top;
            top = new Node(data, top);

        }
        n++;
    }

    public void addBot(T data) {

// Thêm phần tử vào cuối danh sách
        if (n == 0) {
            top = new Node(data);
            bot = top;
        } else {
            Node temp = new Node(data);
            bot.setNext(temp);
            bot = temp;
        }
        n++;
    }

    public T get(int i) {
// Lấy phần tử ở vị trí thứ i
        if (i < 0 || i > n - 1) throw new IndexOutOfBoundsException();
        if (top == null)
            return null;
        Node temp = top;
        for (int j = 0; j < i; j++) {
            temp = temp.getNext();
        }
        return temp.getData();
    }

    public void set(int i, T data) {
// Gán giá trị ở vị trí i bằng data
        if (i < 0 || i > n - 1) throw new IndexOutOfBoundsException();
        Node temp = top;
        for (int j = 0; j < i; j++) {
            temp = temp.getNext();
        }
        temp.setData(data);
    }

    public boolean isContain(T data) {
        // Kiểm tra trong danh sách có chứa phần tử data hay không?
        if (data == null) {
            Node temp = top;
            for (int j = 0; j < n; j++) {
                if (temp.getData() == null) return true;
                else {
                    temp = temp.getNext();
                }
            }
        } else if (!isEmpty()) {
            Node temp = top;
            for (int j = 0; j < n; j++) {
                if (temp.getData().equals(data)) return true;
                else {
                    temp = temp.getNext();
                }
            }
        }
        return false;
    }

    public int indexOf(T data) {
        // Kiểm tra trong danh sách có chứa phần tử data hay không?
        if (data == null) {
            Node temp = top;
            for (int j = 0; j < n; j++) {
                if (temp.getData() == null) return j;
                else {
                    temp = temp.getNext();
                }
            }
        }
        if (!isEmpty()) {
            Node temp = top;
            for (int j = 0; j < n; j++) {
                if (temp.getData().equals(data)) return j;
                else {
                    temp = temp.getNext();
                }
            }
        }
        return -1;
    }

    public int size() {

        // Trả lại thông tin số phần tử có trong danh sách
        return n;

    }

    public boolean isEmpty() {

// Kiểm tra danh sách có rỗng hay không?
        return top == null;

    }

    public T removeTop() {
// Xóa phần tử ở đầu danh sách, trả lại giá trị data của phần tử đó
        if (isEmpty()) throw new IndexOutOfBoundsException();
        T temp = top.getData();
        if (n > 1)
            top = top.getNext();
        else {
            top = null;
            bot = null;
        }
        n--;
        return temp;
    }

    public T removeBot() {
        if (isEmpty()) throw new IndexOutOfBoundsException();
// Xóa phần tử ở cuối danh sách, trả lại giá trị data của phần tử đó
        T temp = bot.getData();
        if (bot == top) {
            top = null;
            bot = null;
        } else {
            Node beforeLast = top;
            for (int i = 0; i < n - 1; i++) {
                beforeLast = beforeLast.getNext();

            }
            beforeLast.setNext(null);
            bot = beforeLast;
        }
        n--;
        return temp;
    }

    public void remove(T data) {
        if (isEmpty()) throw new IndexOutOfBoundsException();
// Xóa tất cả các phần tử có giá trị bằng data
        if (this.isContain(data)) {
            if (top.getData().equals(data)) {
                this.removeTop();
            }
            Node temp = top;
            while (temp != null && temp.getNext() != null) {
                if (temp.getNext().getData().equals(data)) {
                    temp.setNext(temp.getNext().getNext());
                    n--;
                }
                temp = temp.getNext();
            }
            temp = top;
            while (temp != null/*thiếu check chỗ này*/ && temp.getNext() != null) {
                temp = temp.getNext();
            }
            bot = temp;

        } else System.out.println("Not containing");
    }

    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<T> {
        Node pointer = top;

        @Override
        public boolean hasNext() {
            return pointer.getNext() != null;
        }

        @Override
        public T next() {
            Node pointer = this.pointer;
            this.pointer = this.pointer.getNext();
            return pointer.getData();
        }
    }

    public class Node {
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
        }

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}

