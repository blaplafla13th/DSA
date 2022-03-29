package hw5_20001976.bai1;

public class ArrayBinaryTree<E, T> implements BinaryTreeInterface<T> {
    private E[] array;
    private int n = 0;
    private int defaultsize = 100;

    public ArrayBinaryTree() {
        array = (E[]) new Object[defaultsize];

    }

    //update methods
    public void setRoot(E element) {
// Set element to root of an empty tree (at index 1)
    }

    public void setLeft(int p, E element) {
// Set left child of p (at index 2p)
    }

    public void setRight(int p, E element) {
// Set right child of p (at index 2p+1)
    }

    @Override
    public T root() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int numChildren(T p) {
        return 0;
    }

    @Override
    public T parent(T p) {
        return null;
    }

    @Override
    public T left(T p) {
        return null;
    }

    @Override
    public T right(T p) {
        return null;
    }

    @Override
    public T sibling(T p) {
        return null;
    }
}
