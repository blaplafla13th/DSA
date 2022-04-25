package hw7_20001976.arraylist_search;

public abstract class Search<T> {
    protected SimpleArrayList<T> search;
    protected long time;

    public Search(SimpleArrayList<T> search) {
        this.search = search;
    }

    abstract boolean isContain(T data);

    abstract int getIndex(T data);

    public long getRunningTime(T data) {
        this.time = System.nanoTime();
        isContain(data);
        this.time = System.nanoTime() - this.time;
        return this.time;
    }
}
