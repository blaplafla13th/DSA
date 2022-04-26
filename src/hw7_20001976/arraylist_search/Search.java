package hw7_20001976.arraylist_search;

public abstract class Search<T> {
    protected SimpleArrayList<T> search;
    protected long time;

    public Search(SimpleArrayList<T> search) {
        this.search = search;
    }

    abstract boolean isContain(T data);

    abstract int getIndex(T data);

    public void getRunningTime(T data) {
        this.time = System.nanoTime();
        int index = getIndex(data);
        this.time = System.nanoTime() - this.time;
        if (index == -1)
            System.out.printf("khong tim thay phan tu, mat %.3f ms \n", time / 1000000.0);
        else
            System.out.printf("tim thay phan tu tai vi tri %d, mat %.3f ms \n", index, time / 1000000.0);
    }
}
