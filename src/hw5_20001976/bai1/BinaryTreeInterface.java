package hw5_20001976.bai1;

public interface BinaryTreeInterface<E, T> {

    T addRoot(E element); // Add element to root of an empty tree

    T addLeft(T p, E element); // Add element to left child node of p if empty

    T addRight(T p, E element); // Add element to right child node of p if empty

    void set(T p, E element); // set element to node p

    void setLeft(T p, E element); // Set left child of p (at index 2p+1)

    void setRight(T p, E element); // Set right child of p (at index 2p+2)

    T root();

    int size(); // number of node in tree

    boolean isEmpty();

    int numChildren(T p); // number of children of element p;

    T parent(T p); // return parent of p

    T left(T p); // return left child of p

    T right(T p); // return right child of p

    T sibling(T p); // return sibling of p

    E value(T p); // return value of p

    int height(T p); // height of tree from p
}
