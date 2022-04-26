package hw7_20001976.bai1;

public class BinarySearch<T extends Comparable<? super T>> extends Search<T> {
    public BinarySearch(SimpleArrayList<T> search) {
        super(search);
    }

    @Override
    boolean isContain(T data) {
        return binarySearch(data, 0, search.size() - 1);
    }

    private boolean binarySearch(T data, int startIndex, int endIndex) {
        if (search.get(startIndex).equals(data) || search.get(endIndex).equals(data))
            return true;
        else if (startIndex == endIndex)
            return false;
        else {
            int middleIndex = (startIndex + endIndex) / 2;
            if (search.get(middleIndex).equals(data))
                return true;
            else if (data.compareTo(search.get(middleIndex)) < 0) {
                middleIndex--;
                return binarySearch(data, startIndex, middleIndex);
            } else if (data.compareTo(search.get(middleIndex)) > 0) {
                middleIndex++;
                return binarySearch(data, middleIndex, endIndex);
            }
        }
        return false;
    }

    @Override
    int search(T data) {
        return binarySearchIndex(data, 0, search.size() - 1);
    }

    private int binarySearchIndex(T data, int startIndex, int endIndex) {
        if (search.get(startIndex).equals(data))
            return startIndex;
        else if (search.get(endIndex).equals(data))
            return endIndex;
        else if (startIndex == endIndex)
            return -1;
        else {
            int middleIndex = (startIndex + endIndex) / 2;
            if (search.get(middleIndex).equals(data))
                return middleIndex;
            else if (data.compareTo(search.get(middleIndex)) < 0) {
                middleIndex--;
                return binarySearchIndex(data, startIndex, middleIndex);
            } else if (data.compareTo(search.get(middleIndex)) > 0) {
                middleIndex++;
                return binarySearchIndex(data, middleIndex, endIndex);
            }
        }
        return -1;
    }
}
