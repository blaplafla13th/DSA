package hw5_20001976;

import hw5_20001976.bai1.LinkedBinaryTree;
import hw5_20001976.bai1.LinkedBinaryTree.Node;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static hw5_20001976.Bai1Y3Linked.add;

public class P869 {
    public static void main(String[] args) {
        LinkedBinaryTree<Integer> list = new LinkedBinaryTree<>();
        add(list.addRoot(0), 0, list, 0, 5);
        TreeView<Integer> treeView = new TreeView<>(list);
    }
}

class TreeView<E> extends JPanel {
    protected LinkedBinaryTree<E> tree;
    protected int treeHeight;
    protected Font font = new Font("Roman", Font.BOLD, 14);

    public TreeView(LinkedBinaryTree<E> tree) {
        setBackground(Color.white);
        setForeground(Color.black);
        JFrame f = new JFrame("BinaryTree View");
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        f.getContentPane().add(this, BorderLayout.CENTER);
        f.setSize(new Dimension(500, 500));
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        this.tree = tree;
        this.treeHeight = tree.height(tree.root());
    }

    protected void drawTree(Graphics g, int minX, int maxX,
                            int y, int yStep, Node<E> node, LinkedBinaryTree<E> tree) {
        String s = tree.value(node).toString();

        g.setFont(font);
        FontMetrics fm = g.getFontMetrics();
        int width = fm.stringWidth(s);
        int height = fm.getHeight();

        int xSep = Math.min((maxX - minX) / 8, 10);

        g.drawString(s, (minX + maxX) / 2 - width / 2, y + yStep / 2);

        if (tree.left(node) != null) {
            // if left tree not empty, draw line to it and recursively
            // draw that tree
            g.drawLine((minX + maxX) / 2 - xSep, y + yStep / 2 + 5,
                    (minX + (minX + maxX) / 2) / 2,
                    y + yStep + yStep / 2 - height);
            drawTree(g, minX, (minX + maxX) / 2, y + yStep, yStep, tree.left(node), tree);
        }
        if (tree.right(node) != null) {
            // same thing for right subtree.
            g.drawLine((minX + maxX) / 2 + xSep, y + yStep / 2 + 5,
                    (maxX + (minX + maxX) / 2) / 2,
                    y + yStep + yStep / 2 - height);
            drawTree(g, (minX + maxX) / 2, maxX, y + yStep, yStep, tree.right(node), tree);
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);      //clears the background
        int width = getWidth();
        int height = getHeight();
        drawTree(g, 0, width, 0, height / (treeHeight + 1), tree.root(), tree);

    }
}

