package hw5_20001976.bai1;

import java.io.OutputStream;
import java.io.PrintStream;

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

    public default String preOrderPrint(T p) {
        StringBuilder s = new StringBuilder();
        PrintStream out = System.out;
        System.setOut(new PrintStream(OutputStream.nullOutputStream()));
        if (this.value(p) != null) {
            //root
            s.append(this.value(p) + " ");
            //left
            if (this.left(p) != null && this.left(p) != new Integer(-1)) {
                s.append(this.preOrderPrint(this.left(p)));
            }
            //right
            if (this.right(p) != null && this.right(p) != new Integer(-1)) {
                s.append(this.preOrderPrint(this.right(p)));
            }
            return s.toString();
        }
        return "";
    }

    ;

    public default String postOrderPrint(T p) {
        StringBuilder s = new StringBuilder();
        PrintStream out = System.out;
        System.setOut(new PrintStream(OutputStream.nullOutputStream()));
        if (this.value(p) != null) {
            //left
            if (this.left(p) != null && this.left(p) != new Integer(-1)) {
                s.append(this.preOrderPrint(this.left(p)));
            }
            //right
            if (this.right(p) != null && this.right(p) != new Integer(-1)) {
                s.append(this.preOrderPrint(this.right(p)));
            }
            //root
            s.append(this.value(p) + " ");
            return s.toString();
        }
        return "";
    }

    ;

    public default String inOrderPrint(T p) {
        StringBuilder s = new StringBuilder();
        PrintStream out = System.out;
        System.setOut(new PrintStream(OutputStream.nullOutputStream()));
        if (this.value(p) != null) {
            //left
            if (this.left(p) != null && this.left(p) != new Integer(-1)) {
                s.append(this.preOrderPrint(this.left(p)));
            }
            //root
            s.append(this.value(p) + " ");
            //right
            if (this.right(p) != null && this.right(p) != new Integer(-1)) {
                s.append(this.preOrderPrint(this.right(p)));
            }
            return s.toString();
        }
        return "";
    }


}
