package hw5_20001976.bai1;
@SuppressWarnings("unchecked")
public class ArrayBinaryTree<E> implements BinaryTreeInterface<E, Integer> {
    private E[] array;
    private int n = 0;
    private int defaultsize = 100;

    public ArrayBinaryTree() {
        array = (E[]) new Object[defaultsize];
    }

    public ArrayBinaryTree(int size) {
        array = (E[]) new Object[size];
    }


    @Override
    public Integer addRoot(E element) {
        if (array[0] == null) {
            array[0] = element;
            n++;
        } else System.out.println("Tree has root already");
        return 0;
    }

    @Override
    public Integer addLeft(Integer p, E element) {
        if (p == null) {
            System.out.println("Node unknown");
            return -1;
        } else if (p < 0 || p >= array.length) {
            System.out.println("Out of index");
            return -1;
        }
        if (array[p] == null) {
            System.out.println("Node unknown");
            return -1;
        }
        int index = 2 * p + 1;
        if (index < 0 || index >= array.length) {
            System.out.println("Out of index");
            return -1;
        } else if (array[index] != null) {
            System.out.println("Node has left already");
            return -1;
        } else {
            array[index] = element;
            n++;
        }
        return index;
    }

    @Override
    public Integer addRight(Integer p, E element) {
        if (p == null) {
            System.out.println("Node unknown");
            return -1;
        } else if (p < 0 || p >= array.length) {
            System.out.println("Out of index");
            return -1;
        }
        if (array[p] == null) {
            System.out.println("Node unknown");
            return -1;
        }
        int index = 2 * p + 2;
        if (index < 0 || index >= array.length) {
            System.out.println("Out of index");
            return -1;
        } else if (array[index] != null) {
            System.out.println("Node has left already");
        } else {
            array[index] = element;
            n++;
        }
        return index;
    }

    @Override
    public void set(Integer p, E element) {
        if (p == null)
            System.out.println("Node unknown");
        else if (p < 0 || p >= array.length)
            System.out.println("Out of index");
        else if (array[p] == null)
            System.out.println("Node unknown");
        else
            array[p] = element;
    }

    @Override
    public void setLeft(Integer p, E element) {
        if (p == null)
            System.out.println("Node unknown");
        else if (p < 0 || p >= array.length) {
            System.out.println("Out of index");
        } else if (array[p] == null) {
            System.out.println("Node unknown");
        } else if (2 * p + 1 < 0 || 2 * p + 1 >= array.length)
            System.out.println("Out of index");
        else if (array[2 * p + 1] != null)
            array[2 * p + 1] = element;
        else addLeft(p, element);
    }

    @Override
    public void setRight(Integer p, E element) {
        if (p == null)
            System.out.println("Node unknown");
        else if (p < 0 || p >= array.length) {
            System.out.println("Out of index");
        } else if (array[p] == null) {
            System.out.println("Node unknown");
        } else if (2 * p + 1 < 0 || 2 * p + 1 >= array.length)
            System.out.println("Out of index");
        else if (array[2 * p + 2] != null)
            array[2 * p + 2] = element;
        else addRight(p, element);
    }

    @Override
    public Integer root() {
        return 0;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public int numChildren(Integer p) {
        int count = 0;
        if (p == null) {
            System.out.println("Node unknown");
            return 0;
        } else if (p < 0 || p >= array.length) {
            System.out.println("Out of index");
            return 0;
        } else if (array[p] == null) {
            System.out.println("Node unknown");
            return 0;
        }
        if (2 * p + 1 > 0 && 2 * p + 1 < array.length && array[2 * p + 1] != null)
            count++;
        if (2 * p + 2 > 0 && 2 * p + 2 < array.length && array[2 * p + 2] != null)
            count++;
        return count;
    }

    @Override
    public Integer parent(Integer p) {
        if (p <= 0 || p >= array.length || (p - 1) / 2 >= array.length) {
            System.out.println("Out of index");
            return -1;
        } else if (array[p] == null) {
            System.out.println("Node unknown");
            return -1;
        }
        return (p - 1) / 2;
    }

    @Override
    public Integer left(Integer p) {
        if (p == null) {
            System.out.println("Node unknown");
            return -1;
        } else if (p < 0 || p >= array.length || 2 * p + 1 < 0 || 2 * p + 1 >= array.length) {
            System.out.println("Out of index");
            return -1;
        } else if (array[p] == null) {
            System.out.println("Node unknown");
            return -1;
        }
        if (array[2 * p + 1] != null)
            return 2 * p + 1;
        else
            System.out.println("Dont have left child");
        return -1;
    }

    @Override
    public Integer right(Integer p) {
        if (p == null) {
            System.out.println("Node unknown");
            return -1;
        } else if (p < 0 || p >= array.length || 2 * p + 2 < 0 || 2 * p + 2 >= array.length) {
            System.out.println("Out of index");
            return -1;
        } else if (array[p] == null) {
            System.out.println("Node unknown");
            return -1;
        }
        if (array[2 * p + 2] != null)
            return 2 * p + 2;
        else
            System.out.println("Dont have right child");
        return -1;
    }

    @Override
    public Integer sibling(Integer p) {
        if (p <= 0 || p >= array.length || (p - 1) / 2 >= array.length) {
            System.out.println("Out of index");
            return -1;
        } else if (array[p] == null) {
            System.out.println("Node unknown");
            return -1;
        } else if (p % 2 == 0 && array[p - 1] != null) {
            return p - 1;
        } else if (p % 2 == 1 && array[p + 1] != null) {
            return p + 1;
        }
        return -1;
    }

    @Override
    public E value(Integer p) {
        if (p < 0 || p >= array.length) {
            System.out.println("Out of index");
            return null;
        }
        return array[p];
    }
}
