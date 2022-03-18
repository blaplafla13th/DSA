package hw4_20001976_PhamBaThang.bai6.maze;

import hw4_20001976_PhamBaThang.bai2.LinkedListStack;

import javax.swing.*;
import java.awt.*;

public class MazeViewer extends JFrame {
    private final int[][] maze;
    private final LinkedListStack<Position> path = new LinkedListStack<>();
    int startX;
    int startY;
    int endX;
    int endY;

    public MazeViewer(int[][] maze, int startX, int startY, int endX, int endY) {
        this.maze = maze;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MazeSolver.findPath(maze, path, startX, startY, endX, endY);
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }

    @Override
    public void paint(Graphics g) {
        while (!path.isEmpty()) {
            int x = path.top().getX();
            int y = path.top().getY();
            path.pop();
            maze[y][x] = 5;
        }
        maze[startY][startX] = 4;
        maze[endY][endX] = 3;

        for (int y = 0; y < maze.length; y++) {
            for (int x = 0; x < maze[0].length; x++) {
                Color color = switch (maze[y][x]) {
                    case 5 -> Color.GREEN;
                    case 4 -> Color.RED;
                    case 3 -> Color.YELLOW;
                    case 0 -> Color.WHITE;
                    case 1 -> Color.BLACK;
                    default -> Color.PINK;
                };
                g.setColor(color);
                g.fillRect(20 * x + 40, 20 * y + 40, 20, 20);
            }
        }

    }
}
