package hw7_20001976.tree;

import javax.swing.*;
import java.awt.*;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

@SuppressWarnings("unchecked,rawtypes")

public class TreeViewer extends JPanel {
    protected BinarySearchTree tree;
    protected int treeHeight;

    public TreeViewer(BinarySearchTree tree, String title) {
        JFrame f = new JFrame(title);
        f.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        f.getContentPane().add(this, BorderLayout.CENTER);
        f.setSize(new Dimension(500, 500));
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        this.tree = tree;
        this.treeHeight = tree.height(tree.root());
    }

    protected void drawTree(Graphics g, int minX, int maxX,
                            int y, int yStep, BinarySearchTree.Node node, BinarySearchTree tree) {
        String s = tree.value(node).toString(); // get data of node
        // get text size
        FontMetrics fm = g.getFontMetrics();
        int width = fm.stringWidth(s);
        int height = fm.getHeight();

        int xStep = Math.min((maxX - minX) / 8, 10);

        g.drawString(s, (minX + maxX) / 2 - width / 2, y + yStep / 2);

        if (tree.left(node) != null) {
            // if left tree not empty, draw line to it and recursively
            // draw that tree
            g.drawLine((minX + maxX) / 2 - xStep, y + yStep / 2 + 5,
                    (minX + (minX + maxX) / 2) / 2,
                    y + yStep + yStep / 2 - height);
            drawTree(g, minX, (minX + maxX) / 2, y + yStep, yStep, tree.left(node), tree);
        }
        if (tree.right(node) != null) {
            // same thing for right subtree.
            g.drawLine((minX + maxX) / 2 + xStep, y + yStep / 2 + 5,
                    (maxX + (minX + maxX) / 2) / 2,
                    y + yStep + yStep / 2 - height);
            drawTree(g, (minX + maxX) / 2, maxX, y + yStep, yStep, tree.right(node), tree);
        }
    }

    protected void paintComponent(Graphics g) {
        int width = getWidth();
        int height = getHeight();
        drawTree(g, 0, width, 0, height / (treeHeight + 1), tree.root(), tree);

    }
}
