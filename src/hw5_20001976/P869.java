package hw5_20001976;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("unchecked")
public class P869 {
    public static void main(String[] args) {
        BinaryTree<String> tree1 = new BinaryTree<>("Nam",
                new BinaryTree<>("Phan Ngọc Thanh"),
                new BinaryTree<>("SuperStarDeathNo1"));
        BinaryTree<String> tree2 = new BinaryTree<>("Nữ",
                new BinaryTree<>("Phan Thanh Ngọc"),
                new BinaryTree<>("Blaplafla13th"));
        BinaryTree<String> tree = new BinaryTree<>("Phạm Bá Thắng", tree1, tree2);
        tree.rotateLeft();
        BinaryTreeView<String> btv = new BinaryTreeView<>(tree, 400, 400);
        btv.refresh();
    }
}

class BinaryTreeView<E> extends JPanel {

    /* The tree currently being display */
    protected BinaryTree<E> tree;

    /* The max. height of any tree drawn so far.  This
       is used to avoid the tree jumping around when nodes
       are removed from the tree. */
    protected int maxHeight;

    /* The font for the tree nodes. */
    protected Font font = new Font("Roman", Font.BOLD, 14);

    /*
     * Create a new window with the given width and height
     * that is showing the given tree.
     */
    public BinaryTreeView(BinaryTree<E> tree, int width, int height) {

        //Initialize drawing colors, border, opacity.
        setBackground(Color.white);
        setForeground(Color.black);

        // Create window and make it so hitting the close icon
        // will terminate the program
        JFrame f = new JFrame("BinaryTree View");
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        f.getContentPane().add(this, BorderLayout.CENTER);
        f.setSize(new Dimension(width, height));
        f.setVisible(true);

        // install initial tree.
        setTree(tree);
    }

    /*
     * Set the display to show the given tree.
     */
    public void setTree(BinaryTree<E> t) {
        tree = t;
        maxHeight = tree.height();
    }

    /*
     * Invoke this method whenever you would like the window
     * to be refreshed, such as after updating the tree in some
     * way.
     */
    public void refresh() {
        paintImmediately(0, 0, getWidth(), getHeight());
    }


    /*
     * Draw the contents of the tree into the given Graphics
     * context.
     * It will place all info between minX and maxX in the x-direction,
     * starting at location y in the y-direction.  Levels of the tree
     * will be separated by yStep pixels.
     */
    protected void drawTree(Graphics g, int minX, int maxX,
                            int y, int yStep, BinaryTree<E> tree) {

        String s = tree.value().toString();

        g.setFont(font);
        FontMetrics fm = g.getFontMetrics();
        int width = fm.stringWidth(s);
        int height = fm.getHeight();

        int xSep = Math.min((maxX - minX) / 8, 10);

        g.drawString(s, (minX + maxX) / 2 - width / 2, y + yStep / 2);

        if (!tree.left().isEmpty()) {
            // if left tree not empty, draw line to it and recursively
            // draw that tree
            g.drawLine((minX + maxX) / 2 - xSep, y + yStep / 2 + 5,
                    (minX + (minX + maxX) / 2) / 2,
                    y + yStep + yStep / 2 - height);
            drawTree(g, minX, (minX + maxX) / 2, y + yStep, yStep, tree.left());
        }
        if (!tree.right().isEmpty()) {
            // same thing for right subtree.
            g.drawLine((minX + maxX) / 2 + xSep, y + yStep / 2 + 5,
                    (maxX + (minX + maxX) / 2) / 2,
                    y + yStep + yStep / 2 - height);
            drawTree(g, (minX + maxX) / 2, maxX, y + yStep, yStep, tree.right());
        }
    }


    /*
     * paint method unherited from the Swing library.  Just
     * calls drawTree whenever the window needs to be repainted.
     */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);      //clears the background
        int width = getWidth();
        int height = getHeight();
        maxHeight = Math.max(tree.height(), maxHeight);
        int treeHeight = maxHeight;

        drawTree(g, 0, width, 0, height / (treeHeight + 1), tree);

    }
}

class BinaryTree<E> {
    protected E val;
    protected BinaryTree<E> parent;
    protected BinaryTree<E> left;
    protected BinaryTree<E> right;

    public BinaryTree() {
        this.val = null;
        this.parent = null;
        this.left = this.right = this;
    }

    public BinaryTree(E value) {
        this.val = value;
        this.right = this.left = new BinaryTree();
        this.setLeft(this.left);
        this.setRight(this.right);
    }

    public BinaryTree(E value, BinaryTree<E> left, BinaryTree<E> right) {
        this.val = value;
        if (left == null) {
            left = new BinaryTree();
        }

        this.setLeft(left);
        if (right == null) {
            right = new BinaryTree();
        }

        this.setRight(right);
    }

    public BinaryTree<E> left() {
        return this.left;
    }

    public BinaryTree<E> right() {
        return this.right;
    }

    public BinaryTree<E> parent() {
        return this.parent;
    }

    public void setLeft(BinaryTree<E> newLeft) {
        if (!this.isEmpty()) {
            if (this.left != null && this.left.parent() == this) {
                this.left.setParent(null);
            }

            this.left = newLeft;
            this.left.setParent(this);
        }
    }

    public void setRight(BinaryTree<E> newRight) {
        if (!this.isEmpty()) {
            if (this.right != null && this.right.parent() == this) {
                this.right.setParent(null);
            }

            this.right = newRight;
            this.right.setParent(this);
        }
    }

    protected void setParent(BinaryTree<E> newParent) {
        if (!this.isEmpty()) {
            this.parent = newParent;
        }

    }

    public int size() {
        return this.isEmpty() ? 0 : this.left().size() + this.right().size() + 1;
    }

    public BinaryTree<E> root() {
        return this.parent() == null ? this : this.parent().root();
    }

    public int height() {
        return this.isEmpty() ? -1 : 1 + Math.max(this.left.height(), this.right.height());
    }

    public int depth() {
        return this.parent() == null ? 0 : 1 + this.parent.depth();
    }

    public boolean isFull() {
        if (this.isEmpty()) {
            return true;
        } else if (this.left().height() != this.right().height()) {
            return false;
        } else {
            return this.left().isFull() && this.right().isFull();
        }
    }

    public boolean isEmpty() {
        return this.val == null;
    }

    public boolean isComplete() {
        if (this.isEmpty()) {
            return true;
        } else {
            int leftHeight = this.left().height();
            int rightHeight = this.right().height();
            boolean leftIsFull = this.left().isFull();
            boolean rightIsFull = this.right().isFull();
            boolean leftIsComplete = this.left().isComplete();
            boolean rightIsComplete = this.right().isComplete();
            if (leftIsFull && rightIsComplete && leftHeight == rightHeight) {
                return true;
            } else {
                return leftIsComplete && rightIsFull && leftHeight == rightHeight + 1;
            }
        }
    }

    public boolean isBalanced() {
        if (this.isEmpty()) {
            return true;
        } else {
            return Math.abs(this.left().height() - this.right().height()) <= 1 && this.left().isBalanced() && this.right().isBalanced();
        }
    }

    protected void rotateRight() {
        BinaryTree<E> parent = this.parent();
        BinaryTree<E> newRoot = this.left();
        boolean wasChild = parent != null;
        boolean wasLeftChild = this.isLeftChild();
        this.setLeft(newRoot.right());
        newRoot.setRight(this);
        if (wasChild) {
            if (wasLeftChild) {
                parent.setLeft(newRoot);
            } else {
                parent.setRight(newRoot);
            }
        }

    }

    protected void rotateLeft() {
        BinaryTree<E> parent = this.parent();
        BinaryTree<E> newRoot = this.right();
        boolean wasChild = parent != null;
        boolean wasRightChild = this.isRightChild();
        this.setRight(newRoot.left());
        newRoot.setLeft(this);
        if (wasChild) {
            if (wasRightChild) {
                parent.setRight(newRoot);
            } else {
                parent.setLeft(newRoot);
            }
        }

    }

    public boolean isLeftChild() {
        if (this.parent() == null) {
            return false;
        } else {
            return this == this.parent().left();
        }
    }

    public boolean isRightChild() {
        if (this.parent() == null) {
            return false;
        } else {
            return this == this.parent().right();
        }
    }

    public E value() {
        return this.val;
    }

    public void setValue(E value) {
        this.val = value;
    }

    public int hashCode() {
        if (this.isEmpty()) {
            return 0;
        } else {
            int result = this.left().hashCode() + this.right().hashCode();
            if (this.value() != null) {
                result += this.value().hashCode();
            }

            return result;
        }
    }

    public String treeString() {
        StringBuilder s = new StringBuilder();

        s.append("\t|".repeat(Math.max(0, this.depth())));

        s.append("<").append(this.val).append(" : ").append(this.getHand()).append(">\n");
        if (!this.left.isEmpty()) {
            s.append(this.left.treeString());
        }

        if (!this.right.isEmpty()) {
            s.append(this.right.treeString());
        }

        return s.toString();
    }

    private String getHand() {
        if (this.isRightChild()) {
            return "R";
        } else {
            return this.isLeftChild() ? "L" : "Root";
        }
    }

    public String toString() {
        if (this.isEmpty()) {
            return "<BinaryTree: empty>";
        } else {
            StringBuilder s = new StringBuilder();
            s.append("<BinaryTree ").append(this.value());
            if (!this.left().isEmpty()) {
                s.append(" ").append(this.left());
            } else {
                s.append(" -");
            }

            if (!this.right().isEmpty()) {
                s.append(" ").append(this.right());
            } else {
                s.append(" -");
            }

            s.append('>');
            return s.toString();
        }
    }
}

