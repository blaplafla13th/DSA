package hw7_20001976.node_search;

public abstract class Search<K> {
    protected int size;
    protected long time;

    abstract Node<K> insert(K key);

    abstract boolean isContain(K data);

    abstract Node<K> getItem(K data);

    public long getRunningTime(K data) {
        this.time = System.nanoTime();
        isContain(data);
        this.time = System.nanoTime() - this.time;
        return this.time;
    }

    public int getSize() {
        return size;
    }
}
