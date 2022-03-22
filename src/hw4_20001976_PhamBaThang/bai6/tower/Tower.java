package hw4_20001976_PhamBaThang.bai6.tower;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;
import java.util.Stack;

public class Tower extends JPanel implements MouseListener, MouseMotionListener {

    public static final long serialVersionUID = 0xff;
    private static Rectangle2D.Double top = null;
    private Stack<Rectangle2D.Double> s[] = new Stack[3];
    private Stack<Color> disk_color[] = new Stack[3];
    private Color top_color = null;
    private double ax, ay, w, h;
    private boolean draggable = false, firstTime = false;

    public Tower() {
        firstTime = true;
        init(4);
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    public void init(int val) {
        Color c[] = {Color.yellow, Color.red, Color.blue, Color.pink, Color.cyan, Color.magenta, Color.green, Color.orange, Color.lightGray};

        s[0] = new Stack<Rectangle2D.Double>();
        s[1] = new Stack<Rectangle2D.Double>();
        s[2] = new Stack<Rectangle2D.Double>();

        disk_color[0] = new Stack<Color>();
        disk_color[1] = new Stack<Color>();
        disk_color[2] = new Stack<Color>();

        for (int i = 0; i < val; i++) {
            Rectangle2D.Double r = new Rectangle2D.Double();

            double x = getWidth() / 6;
            x = (x == 0) ? 109 : x;
            double wr = val * 25 - 20 * i;
            r.setFrame(x - wr / 2, 190 - i * 20, wr, 20);
            s[0].push(r);
            disk_color[0].push(c[i]);
        }

        top = null;
        top_color = null;
        ax = 0.0;
        ay = 0.0;
        w = 0.0;
        h = 0.0;
        draggable = false;
        repaint();
    }

    public void mouseClicked(MouseEvent ev) {
    }

    public void mousePressed(MouseEvent ev) {
        Point pos = ev.getPoint();
        int n = current_tower(pos);
        if (!s[n].empty()) {
            top = s[n].peek();
            if (top.contains(pos)) {
                top = s[n].pop();
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
        if (top != null && draggable == true) {
            int tower = current_tower(ev.getPoint());
            double x, y;
            if (!s[tower].empty()) {
                if (s[tower].peek().getWidth() > top.getWidth())
                    y = s[tower].peek().getY() - 20;  //calculating ay for dragged disk for placement
                else {
                    JOptionPane.showMessageDialog(this, "Wrong Move", "Tower Of Hanoi", JOptionPane.ERROR_MESSAGE);
                    tower = current_tower(new Point((int) ax, (int) ay));
                    if (!s[tower].empty())
                        y = s[tower].peek().getY() - 20;
                    else
                        y = getHeight() - 40;
                    //return; //cannot put bigger disk on a smaller one
                }
            } else
                y = getHeight() - 40;  //if no previous disk in tower

            x = (int) (getWidth() / 6 + (getWidth() / 3) * tower - top.getWidth() / 2);
            top.setFrame(x, y, top.getWidth(), top.getHeight());
            s[tower].push(top);
            disk_color[tower].push(top_color);

            top = null;
            top_color = Color.black;
            draggable = false;
            repaint();
        }
    }

    public void mouseEntered(MouseEvent ev) {
    }

    public void mouseExited(MouseEvent ev) {
    }

    public void mouseMoved(MouseEvent ev) {
    }

    public void mouseDragged(MouseEvent ev) {
        int cx = ev.getX();   //getting current mouse position
        int cy = ev.getY();
        if (top != null && draggable == true) {
            top.setFrame(cx - w, cy - h, top.getWidth(), top.getHeight());
            repaint();  //repainting if dragging a disk
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.black);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        int holder_x = getWidth() / 6;
        int holder_y1 = getHeight() - 10 * 20, holder_y2 = getHeight() - 20;

        g2d.setColor(Color.white);
        g2d.setStroke(new BasicStroke(5));
        g2d.drawLine(holder_x, holder_y1, holder_x, holder_y2);
        g2d.drawLine(3 * holder_x, holder_y1, 3 * holder_x, holder_y2);
        g2d.drawLine(5 * holder_x, holder_y1, 5 * holder_x, holder_y2);
        g2d.drawLine(0, holder_y2, getWidth(), holder_y2);

        g2d.setStroke(new BasicStroke(1));

        g2d.setColor(top_color);

        if (draggable == true && top != null)
            g2d.fill(top);  //drawing dragged disk

        drawtower(g2d, 0); //drawing disks of each tower
        drawtower(g2d, 1);
        drawtower(g2d, 2);
    }

    private void drawtower(Graphics2D g2d, int n) {
        if (!s[n].empty()) {
            for (int i = 0; i < s[n].size(); i++) {
                g2d.setColor(disk_color[n].get(i));
                g2d.fill(s[n].get(i));
            }
        }
    }

    private int current_tower(Point p) { //return current tower position with respect to Point p
        Rectangle2D.Double
                rA = new Rectangle2D.Double(),
                rB = new Rectangle2D.Double(),
                rC = new Rectangle2D.Double();

        rA.setFrame(0, 0, getWidth() / 3, getHeight());
        rB.setFrame(getWidth() / 3, 0, getWidth() / 3, getHeight());
        rC.setFrame(2 * getWidth() / 3, 0, getWidth() / 3, getHeight());

        if (rA.contains(p))
            return 0;
        else if (rB.contains(p))
            return 1;
        else if (rC.contains(p))
            return 2;
        else
            return -1;
    }
}
