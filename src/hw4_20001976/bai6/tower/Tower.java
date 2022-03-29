package hw4_20001976.bai6.tower;

import hw4_20001976.bai2.LinkedListStack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;


public class Tower extends JPanel implements MouseListener, MouseMotionListener {
    private Rectangle2D.Double top = null;
    private LinkedListStack<Rectangle2D.Double>[] stack = new LinkedListStack[3];
    private LinkedListStack<Color>[] disk_color = new LinkedListStack[3];
    private Color top_color = null;
    private double ax = 0;
    private double ay = 0;
    private double w = 0;
    private double h = 0;
    private boolean draggable = false;

    public Tower() {
        Color[] c = {Color.yellow, Color.red, Color.blue, Color.pink, Color.cyan, Color.magenta, Color.green, Color.orange, Color.lightGray, Color.white};

        stack[0] = new LinkedListStack<>();
        stack[1] = new LinkedListStack<>();
        stack[2] = new LinkedListStack<>();

        disk_color[0] = new LinkedListStack<>();
        disk_color[1] = new LinkedListStack<>();
        disk_color[2] = new LinkedListStack<>();

        for (int i = 0; i < 10; i++) {
            Rectangle2D.Double rectangle = new Rectangle2D.Double();
            rectangle.setFrame((int) (getWidth() / 6 - (250 - 20 * i) / 2 + 165), 202 - i * 20, 10 * 25 - 20 * i, 20);
            stack[0].push(rectangle);
            disk_color[0].push(c[i]);
        }
        repaint();
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    public void mouseClicked(MouseEvent ev) {
    }

    public void mousePressed(MouseEvent ev) {
        Point pos = ev.getPoint();
        int n = currentTower(pos);
        if (!stack[n].isEmpty()) {
            top = stack[n].top();
            if (top.contains(pos)) {
                top = stack[n].pop();
                top_color = disk_color[n].pop();
                ax = top.getX();
                ay = top.getY();
                w = pos.getX() - ax;
                h = pos.getY() - ay;
                draggable = true;  //allowing dragging if current mouse position is in top disk
            } else {
                top = null;
                top_color = Color.black;
                draggable = false;
            }
        }
    }

    public void mouseReleased(MouseEvent ev) {
        if (top != null && draggable) {
            int tower = currentTower(ev.getPoint());
            double x, y;
            if (!stack[tower].isEmpty()) {
                if (stack[tower].top().getWidth() > top.getWidth())
                    y = stack[tower].top().getY() - 20;  //calculating ay for dragged disk for placement
                else {
                    JOptionPane.showMessageDialog(this, "Wrong Move", "Wrong move", JOptionPane.ERROR_MESSAGE);
                    tower = currentTower(new Point((int) ax, (int) ay));
                    if (!stack[tower].isEmpty())
                        y = stack[tower].top().getY() - 20;
                    else
                        y = getHeight() - 40;
                }
            } else
                y = getHeight() - 40;
            x = (int) (getWidth() / 6 + (getWidth() / 3) * tower - top.getWidth() / 2);
            top.setFrame(x, y, top.getWidth(), top.getHeight());
            stack[tower].push(top);
            disk_color[tower].push(top_color);

            top = null;
            top_color = Color.black;
            draggable = false;
            repaint();
        }
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseDragged(MouseEvent ev) {
        int cx = ev.getX();
        int cy = ev.getY();
        if (top != null && draggable) {
            top.setFrame(cx - w, cy - h, top.getWidth(), top.getHeight());
            repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.black);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        int holder_x = getWidth() / 6;
        int holder_y1 = getHeight() - 300;
        int holder_y2 = getHeight() - 20;

        g2d.setColor(Color.white);
        g2d.setStroke(new BasicStroke(5));
        g2d.drawLine(holder_x, holder_y1, holder_x, holder_y2);
        g2d.drawLine(3 * holder_x, holder_y1, 3 * holder_x, holder_y2);
        g2d.drawLine(5 * holder_x, holder_y1, 5 * holder_x, holder_y2);
        g2d.drawLine(0, holder_y2, getWidth(), holder_y2);

        g2d.setStroke(new BasicStroke(1));

        g2d.setColor(top_color);

        if (draggable && top != null)
            g2d.fill(top);  //drawing dragged disk

        drawTower(g2d, 0); //drawing disks of each tower
        drawTower(g2d, 1);
        drawTower(g2d, 2);
    }

    private void drawTower(Graphics2D g2d, int n) {
        if (!stack[n].isEmpty()) {
            for (int i = 0; i < stack[n].size(); i++) {
                g2d.setColor(disk_color[n].get(i));
                g2d.fill(stack[n].get(i));
            }
        }
    }

    private int currentTower(Point p) { //return current tower position with respect to Point p
        Rectangle2D.Double
                rA = new Rectangle2D.Double(),
                rB = new Rectangle2D.Double(),
                rC = new Rectangle2D.Double();

        rA.setFrame(0, 0, getWidth() / 3.0, getHeight());
        rB.setFrame(getWidth() / 3.0, 0, getWidth() / 3.0, getHeight());
        rC.setFrame(2.0 * getWidth() / 3.0, 0, getWidth() / 3.0, getHeight());

        if (rA.contains(p))
            return 0;
        else if (rB.contains(p))
            return 1;
        else if (rC.contains(p))
            return 2;
        else
            return 0;
    }
}
