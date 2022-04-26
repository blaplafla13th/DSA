package hw7_20001976.list;

public class LinearSearchLinkedList<T> {
    protected SimpleLinkedList<T> search;
    protected long time;

    public LinearSearchLinkedList(SimpleLinkedList<T> search) {
        this.search = search;
    }

    public boolean isContain(T data) {
        for (T element : search) {
            if (element.equals(data))
                return true;
        }
        return false;
    }

    public int search(T data) {
        for (int i = 0; i < search.size(); i++) {
            if (search.get(i).equals(data))
                return i;
        }
        return -1;
    }

    public void getRunningTime(T data) {
        this.time = System.nanoTime();
        int index = search(data);
        this.time = System.nanoTime() - this.time;
        if (index == -1)
            System.out.printf("khong tim thay phan tu, mat %.3f ms \n", time / 1000000.0);
        else
            System.out.printf("tim thay phan tu tai vi tri %d, mat %.3f ms \n", index, time / 1000000.0);
    }
}
