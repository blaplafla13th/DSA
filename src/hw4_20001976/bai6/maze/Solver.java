package hw4_20001976.bai6.maze;

import hw4_20001976.bai2.LinkedListStack;

import javax.swing.*;
import java.awt.*;

public class Solver extends JFrame {
    private final int[][] maze;
    private final LinkedListStack<Block> path = new LinkedListStack<>();
    int startX;
    int startY;
    int endX;
    int endY;

    public Solver(int[][] maze, int startX, int startY, int endX, int endY) {
        this.maze = maze;
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        findPath();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

    public void findPath() {
        boolean done = false;
        path.push(new Block(startY, startX));
        while (!path.isEmpty() && !done) {
            Block current = path.top();
            Block.Movable nextBlock = current.getUnvisitedBlock(maze);

            if (nextBlock == Block.Movable.no)
                path.pop();
            else {
                Block newBlock = current.move(nextBlock);
                maze[newBlock.getY()][newBlock.getX()] = 2;
                path.push(newBlock);
                if (newBlock.getY() == endY && newBlock.getX() == endX)
                    done = true;
            }
        }
    }
}
