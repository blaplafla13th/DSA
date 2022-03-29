package hw4_20001976.bai6.maze;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CreateMapPanel extends JFrame {
    int width;
    int height;
    int startX;
    int startY;
    int endX;
    int endY;
    JComponent[][] matrix;

    public CreateMapPanel(int height, int width, int startX, int startY, int endX, int endY) throws HeadlessException {
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.width = width;
        this.height = height;
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        JPanel testing = new JPanel();
        add(testing);
        JLabel label = new JLabel("Tick the box is obstacle");
        label.setBounds(5, 5, 3000, 10);
        add(label);

        matrix = new JComponent[height][width];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (y == startY && x == startX)
                    matrix[y][x] = new JLabel("  S");
                else if (y == endY && x == endX)
                    matrix[y][x] = new JLabel("  E");
                else
                    matrix[y][x] = new JCheckBox();
                matrix[y][x].setBounds(20 * x, 20 * y + 30, 20, 20);
            }
        }
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                add(matrix[y][x]);
            }
        }
        JButton button = new JButton();
        button.setText("Accept");
        button.setBounds(0, 20 * height + 70, 20 * width, 50);
        button.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int count = 0;
                int[][] map = new int[height][width];
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        if (matrix[i][j] instanceof JLabel)
                            map[i][j] = 0;
                        else if (matrix[i][j] instanceof JCheckBox)
                            if (((JCheckBox) matrix[i][j]).isSelected()) {
                                map[i][j] = 1;
                                count++;
                            } else map[i][j] = 0;
                    }
                }
                if (count > 0) {
                    Solver mazeSolver = new Solver(map, startX, startY, endX, endY);
                    mazeSolver.pack();
                    mazeSolver.setVisible(true);

                } else {
                    JFrame emptyFrame = new JFrame();
                    JLabel empty = new JLabel("There is no obstacle why you need this??");
                    empty.setBounds(10, 10, 300, 100);
                    emptyFrame.add(empty);
                    emptyFrame.setLayout(null);
                    emptyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    emptyFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    emptyFrame.setLocationRelativeTo(null);
                    emptyFrame.pack();
                    emptyFrame.setVisible(true);
                }
                setVisible(false);
            }
        });
        add(button);
    }
}
