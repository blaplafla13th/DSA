package hw7_20001976.bai1;

public class LinearSearch<T> extends Search<T> {
    public LinearSearch(SimpleArrayList<T> search) {
        super(search);
    }

    @Override
    boolean isContain(T data) {
        if (!search.isEmpty())
            for (T element : search) {
                if (data.equals(element))
                    return true;
            }
        return false;
    }

    @Override
    int search(T data) {
        if (!search.isEmpty())
            for (int i = 0; i < search.size(); i++) {
                if (data.equals(search.get(i)))
                    return i;
            }
        return -1;
    }
}
